package saitama.ui;

import java.io.IOException;
import java.util.Collections;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;


/**
 * The dialog box GUI.
 */
public class DialogBox extends HBox {
    @FXML
    private Text dialog;
    @FXML
    private Circle displayPicture;

    private DialogBox(String text, Image img) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(MainWindow.class.getResource("/view/DialogBox.fxml"));
            fxmlLoader.setController(this);
            fxmlLoader.setRoot(this);
            fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        dialog.setText(text);

        ImagePattern imgPtn = new ImagePattern(img);
        displayPicture.setFill(imgPtn);
    }

    /**
     * Flips the dialog box such that the ImageView is on the left and text on the right.
     */
    private void flip() {
        ObservableList<Node> tmp = FXCollections.observableArrayList(getChildren());
        Collections.reverse(tmp);
        getChildren().setAll(tmp);
        dialog.setTextAlignment(TextAlignment.LEFT);
        dialog.setFont(Font.font("Calibri Light", 15));
    }

    /**
     * Returns a DialogBox with the given text and image.
     *
     * @param text The text in the dialog box.
     * @param img The profile picture of the speaker.
     * @return A DialogBox with the given text and image.
     */
    public static DialogBox getUserDialog(String text, Image img) {
        return new DialogBox(text, img);
    }

    /**
     * Returns a flipped DialogBox with the given text and image.
     *
     * @param text Saitama's reply.
     * @param img Saitama's picture.
     * @return A flipped DialogBox with the given text and image.
     */
    public static DialogBox getSaitamaDialog(String text, Image img) {
        var db = new DialogBox(text, img);
        db.flip();
        return db;
    }
}
