/**
 * @license Copyright (c) 2003-2013, CKSource - Frederico Knabben. All rights reserved.
 * For licensing, see LICENSE.html or http://ckeditor.com/license
 */

CKEDITOR.editorConfig = function( config ) {
	// Define changes to default configuration here.
	// For the complete reference:
	// http://docs.ckeditor.com/#!/api/CKEDITOR.config

    /**
     * Sets the behavior for the ENTER key. It also dictates other behaviour
     * rules in the editor, like whether the &lt;br&gt; element is to be used
     * as a paragraph separator when indenting text.
     * The allowed values are the following constants, and their relative
     * behavior:
     * <ul>
     * <li>{@link CKEDITOR.ENTER_P} (1): new &lt;p&gt; paragraphs are created;</li>
     * <li>{@link CKEDITOR.ENTER_BR} (2): lines are broken with &lt;br&gt; elements;</li>
     * <li>{@link CKEDITOR.ENTER_DIV} (3): new &lt;div&gt; blocks are created.</li>
     * </ul>
     * <strong>Note</strong>: It's recommended to use the
     * {@link CKEDITOR.ENTER_P} value because of its semantic value and
     * correctness. The editor is optimized for this value.
     * @type Number
     * @default {@link CKEDITOR.ENTER_P}
     * @example
     * // Not recommended.
     * config.enterMode = CKEDITOR.ENTER_BR;
     */
    config.enterMode = CKEDITOR.ENTER_BR;
    config.shiftEnterMode = CKEDITOR.ENTER_P;

	// The toolbar groups arrangement, optimized for a single toolbar row.
//	config.toolbarGroups = [
//		{ name: 'document',	   groups: [ 'mode', 'document', 'doctools' ] },
//		// On the basic preset, clipboard and undo is handled by keyboard.
//		// Uncomment the following line to enable them on the toolbar as well.
//        { name: 'clipboard',   groups: [ 'clipboard', 'undo' ] },
//		{ name: 'editing',     groups: [ 'find', 'selection', 'spellchecker' ] },
//		{ name: 'forms' },
//		{ name: 'basicstyles', groups: [ 'basicstyles', 'cleanup' ] },
//		{ name: 'paragraph',   groups: [ 'list', 'indent', 'blocks', 'align' ] },
//		{ name: 'links' },
//		{ name: 'insert' },
//		{ name: 'styles' },
//		{ name: 'colors' },
//		{ name: 'tools' },
//		{ name: 'others' },
//		{ name: 'about' }
//	];

    // Toolbar configuration generated automatically by the editor based on config.toolbarGroups.
    config.toolbar = [
        { name: 'document', groups: [ 'mode', 'document', 'doctools' ], items: [ 'Preview', 'Print' ] },
        { name: 'clipboard', groups: [ 'clipboard', 'undo' ], items: [ 'Cut', 'Copy', 'Paste', 'PasteText', 'PasteFromWord', '-', 'Undo', 'Redo' ] },
        { name: 'editing', groups: [ 'find', 'selection' ], items: [ 'Find', 'Replace' ] },
        { name: 'basicstyles', groups: [ 'basicstyles', 'cleanup' ], items: [ 'Bold', 'Italic', 'Underline', 'Strike', 'Subscript', 'Superscript', '-', 'RemoveFormat' ] },
        { name: 'paragraph', groups: [ 'list', 'indent', 'blocks', 'align' ], items: [ 'NumberedList', 'BulletedList', '-', 'Outdent', 'Indent', '-', 'Blockquote', '-', 'JustifyLeft', 'JustifyCenter', 'JustifyRight', 'JustifyBlock' ] },
        { name: 'links', items: [ 'Link', 'Unlink', 'Anchor' ] },
        { name: 'insert', items: [ 'Image', 'Table', 'HorizontalRule', 'PageBreak' ] },
        { name: 'strinsert', items: ['strinsert'] },
        { name: 'styles', items: [ 'Styles', 'Format', 'Font', 'FontSize' ] },
        { name: 'colors', items: [ 'TextColor', 'BGColor' ] },
        { name: 'tools', items: [ 'Maximize', 'ShowBlocks' ] }
//        ,
//        { name: 'others', items: [ '-', 'cronosfile' ] }
    ];

// Toolbar groups configuration.
//    config.toolbarGroups = [
//        { name: 'document', groups: [ 'mode', 'document', 'doctools' ] },
//        { name: 'clipboard', groups: [ 'clipboard', 'undo' ] },
//        { name: 'editing', groups: [ 'find', 'selection' ] },
//        { name: 'basicstyles', groups: [ 'basicstyles', 'cleanup' ] },
//        { name: 'paragraph', groups: [ 'list', 'indent', 'blocks', 'align' ] },
//        { name: 'links' },
//        { name: 'insert' },
//        { name: 'styles' },
//        { name: 'colors' },
//        { name: 'tools' },
//        { name: 'others' }
//    ];

	// The default plugins included in the basic setup define some buttons that
	// we don't want too have in a basic editor. We remove them here.
	config.removeButtons = 'pbckcode';

	// Considering that the basic setup doesn't provide pasting cleanup features,
	// it's recommended to force everything to be plain text.
//	config.forcePasteAsPlainText = true;
    config.forcePasteAsPlainText = false;

	// Let's have it basic on dialogs as well.
	config.removeDialogTabs = 'link:advanced';
    
//    config.extraPlugins = "horizontalrule,cronosfile";
    config.extraPlugins = "horizontalrule";
};

CKEDITOR.on('dialogDefinition', function(ev) {
    var dialogName = ev.data.name;
    var dialogDefinition = ev.data.definition;

//    if (dialogName == 'link') {
//        dialogDefinition.removeContents('target');
//        dialogDefinition.removeContents('advanced');
//
//        var infoTab = dialogDefinition.getContents('info');
//
//        infoTab.remove('linkType');
//        infoTab.remove('protocol');
//    }
    
    if (dialogName == 'image') {
//        dialogDefinition.removeContents('Link');
        dialogDefinition.removeContents('advanced');
        
//        var infoTab = dialogDefinition.getContents('info');
//
//        infoTab.remove('ratioLock');
//        infoTab.remove('htmlPreview');
    }
    
    if (dialogName == 'table' || dialogName == 'tableProperties') {
//        var infoTab = dialogDefinition.getContents('info');
        dialogDefinition.removeContents('advanced');
//
//        infoTab.remove('cmbAlign');
//        infoTab.remove('txtSummary');
    }
});