(ns status-im.ui.components.desktop.views
  (:require
   [status-im.ui.components.icons.vector-icons :as icons]
   [status-im.ui.components.common.styles :as styles]
   [status-im.ui.components.checkbox.styles :as checkbox.styles]
   [status-im.ui.components.react :as react]
   [status-im.ui.components.colors :as colors]))

(defn checkbox [{:keys [on-value-change checked?]}]
  [react/touchable-highlight {:style checkbox.styles/wrapper :on-press #(do (when on-value-change (on-value-change (not checked?))))}
   [react/view {:style (checkbox.styles/icon-check-container checked?)}
    (when checked?
      [icons/icon :main-icons/check {:style checkbox.styles/check-icon}])]])

;; TODO should be removed when 2-pane UI will be used

(defn action-button [{:keys [label icon icon-opts on-press label-style cyrcle-color]}]
  [react/touchable-highlight {:on-press on-press}])

(defn separator [style & [wrapper-style]]
  [react/view {:style (merge styles/separator-wrapper wrapper-style)}
   [react/view {:style (merge styles/separator style)}]])

(def sticky-button-style
  {:flex-direction   :row
   :height           52
   :justify-content  :center
   :align-items      :center
   :background-color colors/blue})

(def sticky-button-label-style
  {:color       colors/white
   :font-size   17})

(defn sticky-button [label on-press]
  [react/touchable-highlight {:on-press on-press}
   [react/view {:style sticky-button-style}
    [react/text {:style sticky-button-label-style}
     label]]])

(defn button-label-style
  [enabled?]
  {:color   colors/blue
   :opacity (if enabled? 1 0.3)})

(defn button [label enabled? on-press]
  [react/touchable-highlight {:on-press on-press :disabled (not enabled?)}
   [react/view {:style {:width            290
                        :height           52
                        :align-items      :center
                        :justify-content  :center
                        :border-radius    8
                        :background-color :white}}
                        ;:box-shadow       "0 2px 6px 0 rgba(0, 0, 0, 0.25)"}}
    [react/text {:style (button-label-style enabled?)}
     label]]])

(def text-button-label-style
  {:color colors/white})

(defn text-button [label on-press]
  [react/touchable-highlight {:on-press on-press}
   [react/view
    [react/text {:style text-button-label-style}
     label]]])

(defn back-button [on-press]
  [react/view {:style {:position :absolute :left 32 :top 32 :z-index 1000}}
   [react/touchable-highlight {:on-press on-press}
    [react/view {:style {:flex-direction :row :align-items :center}}
     [icons/icon :main-icons/back {:color :white}]
     [react/text {:style {:margin-left 16 :color colors/white}} "Back"]]]])
