(ns status-im.ui.screens.multiaccounts.styles
  (:require-macros [status-im.utils.styles :refer [defnstyle defstyle]])
  (:require [status-im.ui.components.styles :as common]
            [status-im.ui.components.colors :as colors]))

(def multiaccounts-view
  {:flex 1})

(def multiaccounts-container
  {:flex               1
   :margin-top         24
   :margin-bottom      16
   :justify-content    :space-between})

(def bottom-actions-container
  {:margin-bottom 16})

(def multiaccount-image-size 40)

(def multiaccount-title-text
  {:color     :black
   :font-size 17})

(defstyle multiaccounts-list-container
  {:flex             1
   :padding-bottom 8})

(defstyle multiaccount-view
  {:background-color   :white
   :flex-direction     :row
   :align-items        :center
   :padding-horizontal 16
   :height             64})

(def multiaccount-badge-text-view
  {:margin-left  16
   :margin-right 31
   :flex-shrink  1})

(def multiaccount-badge-text
  {:font-weight "500"})

(def multiaccount-badge-pub-key-text
  {:font-family "monospace"
   :color       colors/gray})

(def bottom-button
  {:padding-horizontal 24
   :justify-content    :center
   :align-items        :center
   :align-self         :center
   :flex-direction     :row})

(def bottom-button-container
  {:margin-top    14
   :margin-bottom 6})
