### "Convert to Unicode" Plugin User Guide

#### Plugin Overview
The "Convert to Unicode" plugin allows you to convert selected text in the editor to Unicode encoding format. This feature is handy when you need to view or manipulate Unicode encoded text while coding.


#### Using the Plugin

1. **Select the Text to Convert**
   In the code editor, use your mouse or keyboard to select the text you want to convert to Unicode.

2. **Open the Context Menu**
   Right-click the selected text to open the context menu.

3. **Choose "Convert to Unicode"**
   Find and click the "Convert to Unicode" option in the context menu.

4. **Preview the Conversion**
   The plugin will display a dialog showing the Unicode conversion preview of the selected text.

5. **Confirm the Conversion**
   - If the preview is correct, click the `OK` button in the dialog to confirm the conversion and replace the selected text with the Unicode encoded version.
   - If you do not wish to proceed, click the `Cancel` button to abort the operation.

#### Example
Suppose you have the following text in the editor:
```
你好,世界
```
After selecting this text and choosing "Convert to Unicode," a preview dialog will show:
```
Selected text: 你好,世界
Unicode conversion preview: \u4f60\u597d\u002c\u4e16\u754c
```
Clicking `OK` will replace the selected text with:
```
\u4f60\u597d\u002c\u4e16\u754c
```

#### Notes
- The plugin is only available when text is selected.
- If no text is selected, the "Convert to Unicode" option will be unavailable.
- Ensure you save your current file before performing the operation to prevent loss of unsaved changes.

