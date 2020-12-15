package Controller;

import java.util.function.BiConsumer;

import javafx.event.ActionEvent;
import javafx.geometry.Bounds;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.shape.SVGPath;
import javafx.util.Callback;

public class Utils {

	// M�todo gen�rico para adicionar um bot�o dentro da coluna de uma TableColumn
	public static <T> void initButtons(TableColumn<T, T> tableColumn, int size, String svgIcon, String colorClassName,
			BiConsumer<T, ActionEvent> buttonAction) {
		final int COLUMN_ICON_SPACE = 20; // espa�o extra que ter� dentro da c�lula da tabela
		tableColumn.setMinWidth(size + COLUMN_ICON_SPACE);
		tableColumn.setMaxWidth(size + COLUMN_ICON_SPACE);
		tableColumn.setStyle("-fx-alignment: CENTER"); // centraliza os bot�es

		Callback<TableColumn<T, T>, TableCell<T, T>> cellFactory = new Callback<TableColumn<T, T>, TableCell<T, T>>() {
			@Override
			public TableCell<T, T> call(final TableColumn<T, T> param) {
				final TableCell<T, T> cell = new TableCell<T, T>() {
					// chama o m�todo auxiliar para criar um bot�o com o �cone svg dentro
					private final Button btn = createIconButton(svgIcon, size, colorClassName);

					// inseri o bot�o dentro da c�lula
					@Override
					public void updateItem(T item, boolean empty) {
						super.updateItem(item, empty);
						if (empty) {
							setGraphic(null);
						} else {
							setGraphic(btn);
						}
					}

					{
						// define o que ir� acontecer quando o bot�o for clicado
						btn.setOnAction((ActionEvent event) -> {
							T data = getTableView().getItems().get(getIndex());
							buttonAction.accept(data, event);
						});
					}
				};
				return cell;
			}
		};
		tableColumn.setCellFactory(cellFactory);
	}

	// Cria um bot�o com o �cone svg dentro
	public static Button createIconButton(String svgAbsolutePath, int size, String colorClassName) {
		SVGPath path = new SVGPath();
		path.setContent(svgAbsolutePath);
		Bounds bounds = path.getBoundsInLocal();

		// scale to size size x size (max)
		double scaleFactor = size / Math.max(bounds.getWidth(), bounds.getHeight());
		path.setScaleX(scaleFactor);
		path.setScaleY(scaleFactor);
		path.getStyleClass().add(colorClassName); // define a cor do �cone

		Button button = new Button();
		button.setPickOnBounds(true); // Garente que o bot�o ter� o fundo transparente
		button.setGraphic(path); // inseri o �cone gerado pelo svg no bot�o
		button.setAlignment(Pos.CENTER);
		button.getStyleClass().add("icon-button"); // classe criada para n�o ter o fundo cinza
		// necess�rios para o �cone ficar contido dentro do bot�o
		button.setMaxWidth(size);
		button.setMaxHeight(size);
		button.setMinWidth(size);
		button.setMinHeight(size);
		button.setPrefWidth(size);
		button.setPrefHeight(size);
		return button;
	}

}
