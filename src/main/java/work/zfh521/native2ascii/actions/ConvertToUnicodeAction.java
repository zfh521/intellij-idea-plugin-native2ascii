package work.zfh521.native2ascii.actions;

import com.intellij.CommonBundle;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.command.WriteCommandAction;
import com.intellij.openapi.editor.Document;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.ui.Messages;
import org.apache.commons.lang.StringEscapeUtils;

public class ConvertToUnicodeAction extends AnAction {
    @Override
    public void actionPerformed(AnActionEvent e) {
        Project project = e.getProject();
        Editor editor = (Editor) e.getDataContext().getData("editor");

        if (project == null || editor == null) {
            return;
        }
        String selectedText = editor.getSelectionModel().getSelectedText();

        if (selectedText == null || selectedText.isEmpty()) {
            return;
        }
        // 预览转换结果
        String unicodeText = StringEscapeUtils.escapeJava(selectedText);

        if (!confirm(selectedText,unicodeText,project)) {
            return;
        }
        // 用户确认后，执行替换操作
        Document document = editor.getDocument();
        int startOffset = editor.getSelectionModel().getSelectionStart();
        int endOffset = editor.getSelectionModel().getSelectionEnd();

        // 使用 WriteCommandAction 来确保修改是在命令中执行的
        WriteCommandAction.runWriteCommandAction(project, () -> {
            document.replaceString(startOffset, endOffset, unicodeText);
        });
    }
    public boolean confirm(String selectedText, String unicodeText,Project project) {
        String previewMessage = "Selected text: " + selectedText + "\n\nUnicode conversion preview: \n" + unicodeText;
        int choice = Messages.showOkCancelDialog(
                project, previewMessage,
                "Preview Unicode Conversion",
                CommonBundle.getYesButtonText(),
                CommonBundle.getCancelButtonText(),
                Messages.getInformationIcon());
        return choice == Messages.OK;
    }
    private String convertToUnicode(String text) {
        StringBuilder unicodeText = new StringBuilder();
        for (char c : text.toCharArray()) {
            unicodeText.append(String.format("\\u%04x", (int) c));
        }
        return unicodeText.toString();
    }
}
