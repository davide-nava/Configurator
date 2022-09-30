function asideLinkMenuBtn() {
    if ($("body").hasClass("aside-collapsed")) {
        $("body").removeClass("aside-collapsed");
    }
    else {
        $("body").addClass("aside-collapsed");
    }
}


function asidetoggledLinkMenuBtn() {
    if ($("body").hasClass("aside-toggled")) {
        $("body").removeClass("aside-toggled");
    }
    else {
        $("body").addClass("aside-toggled");
    }
}


// Convert a base64 string to a Uint8Array. This is needed to create a blob object from the base64 string.
// The code comes from: https://developer.mozilla.org/fr/docs/Web/API/WindowBase64/D%C3%A9coder_encoder_en_base64
function b64ToUint6(nChr) {
    return nChr > 64 && nChr < 91 ? nChr - 65 : nChr > 96 && nChr < 123 ? nChr - 71 : nChr > 47 && nChr < 58 ? nChr + 4 : nChr === 43 ? 62 : nChr === 47 ? 63 : 0;
}

function base64DecToArr(sBase64, nBlocksSize) {
    var
        sB64Enc = sBase64.replace(/[^A-Za-z0-9\+\/]/g, ""),
        nInLen = sB64Enc.length,
        nOutLen = nBlocksSize ? Math.ceil((nInLen * 3 + 1 >> 2) / nBlocksSize) * nBlocksSize : nInLen * 3 + 1 >> 2,
        taBytes = new Uint8Array(nOutLen);

    for (var nMod3, nMod4, nUint24 = 0, nOutIdx = 0, nInIdx = 0; nInIdx < nInLen; nInIdx++) {
        nMod4 = nInIdx & 3;
        nUint24 |= b64ToUint6(sB64Enc.charCodeAt(nInIdx)) << 18 - 6 * nMod4;
        if (nMod4 === 3 || nInLen - nInIdx === 1) {
            for (nMod3 = 0; nMod3 < 3 && nOutIdx < nOutLen; nMod3++, nOutIdx++) {
                taBytes[nOutIdx] = nUint24 >>> (16 >>> nMod3 & 24) & 255;
            }
            nUint24 = 0;
        }
    }
    return taBytes;
}

function createRichEdit(exportUrl, documentAsBase64) {
    const options = DevExpress.RichEdit.createOptions();
    options.confirmOnLosingChanges.enabled = false;
    options.exportUrl = exportUrl;
    options.width = '1400px';
    options.height = '900px';
    var richElement = document.getElementById("rich-container");
    const richEdit = DevExpress.RichEdit.create(richElement, options);
    if (documentAsBase64)
        richEdit.openDocument(documentAsBase64, "DocumentName", DevExpress.RichEdit.DocumentFormat.Rtf);
}



$(() => {
    const editor = $('.html-editor').dxHtmlEditor({
        height: 300,
        toolbar: {
            items: [
                'undo', 'redo', 'separator',
                {
                    name: 'size',
                    acceptedValues: ['8pt', '10pt', '12pt', '14pt', '18pt', '24pt', '36pt'],
                },
                'separator', 'bold', 'italic', 'strike', 'underline', 'separator',
                'alignLeft', 'alignCenter', 'alignRight', 'alignJustify', 'separator',
                'orderedList', 'bulletList', 'separator',
                {
                    name: 'header',
                    acceptedValues: [false, 1, 2, 3, 4, 5],
                }, 'separator',
                'color', 'background', 'separator',
                'link',  'separator',
                'clear', 'codeBlock', 'blockquote', 'separator',
                'insertTable', 'deleteTable',
                'insertRowAbove', 'insertRowBelow', 'deleteRow',
                'insertColumnLeft', 'insertColumnRight', 'deleteColumn',
            ],
        },
        mediaResizing: {
            enabled: true,
        },
    }).dxHtmlEditor('instance');
});


function prettierFormat(markup) {
    return prettier.format(markup, {
        parser: 'html',
        plugins: prettierPlugins,
    });
}