/**
 * @license Copyright © 2013 Stuart Sillitoe <stuart@vericode.co.uk>
 * This is open source, can modify it as you wish.
 *
 * Stuart Sillitoe
 * stuartsillitoe.co.uk
 *
 */

CKEDITOR.plugins.add('strinsert', {
    requires: ['richcombo'],
    init: function (editor) {
// Gets the list of insertable strings from the settings.
        var strings = [];

        $.ajax({
            type: "GET",
            url: CronosConstants.CKEditor.PlaceholderDropdown.url,
            dataType: "json",
            cache: false,
            error: function (XMLHttpRequest, textStatus, errorThrown) {
                AjaxErrorHandler.setCustomMessage(XMLHttpRequest, "Error occurred");
            },
            success: function (result) {
                strings = result;
            }
        });

        editor.ui.addRichCombo('strinsert', {
                label: CronosConstants.CKEditor.PlaceholderDropdown.label,
                title: CronosConstants.CKEditor.PlaceholderDropdown.label,
                voiceLabel: CronosConstants.CKEditor.PlaceholderDropdown.label,
                className: 'cke_format',
                multiSelect: false,
                panel: {
                    css: [ editor.config.contentsCss, CKEDITOR.skin.getPath('editor') ],
                    voiceLabel: editor.lang.panelVoiceLabel
                },

                init: function () {
                    for (var i = 0, len = strings.length; i < len; i++) {
                        string = strings[i];
// If there is no value, make a group header using the name.
                        if (!string.value) {
                            this.startGroup(string.name);
                        }
// If we have a value, we have a string insert row.
                        else {
// If no name provided, use the value for the name.
                            if (!string.name) {
                                string.name = string.value;
                            }
// If no label provided, use the name for the label.
                            if (!string.label) {
                                string.label = string.name;
                            }
                            this.add(string.value, string.name, string.label);
                        }
                    }
                },

                onClick: function (value) {
                    editor.focus();
                    editor.fire('saveSnapshot');
                    editor.insertHtml(value);
                    editor.fire('saveSnapshot');
                }

            });
    }
});