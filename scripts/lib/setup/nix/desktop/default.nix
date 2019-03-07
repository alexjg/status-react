{ stdenv, pkgs, target-os }:

with pkgs;
with stdenv; 

let
  targetLinux = {
    "linux" = true;
    "" = isLinux;
  }.${target-os} or false;
  targetWindows = {
    "windows" = true;
    "" = isLinux;
  }.${target-os} or false;
  windowsPlatform = callPackage ./windows { };

in
  {
    buildInputs = [
      cmake
      extra-cmake-modules
      go
    ] ++ lib.optional targetLinux [ patchelf ]
      ++ lib.optional (! targetWindows) qt5.full
      ++ lib.optional targetWindows windowsPlatform.buildInputs;
    shellHook = (if target-os == "windows" then "unset QT_PATH" else ''
      export QT_PATH="${qt5.full}"
      export PATH="${qt5.full}/bin:$PATH"
    '') + (lib.optionalString isDarwin ''
      export MACOSX_DEPLOYMENT_TARGET=10.9
    '');
  }