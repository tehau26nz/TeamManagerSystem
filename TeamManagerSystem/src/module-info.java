module TeamManagerSystem {
	requires javafx.controls;
	requires javafx.fxml;
	requires javafx.graphics;
	requires javafx.base;
	requires org.junit.jupiter.api;
	requires org.junit.jupiter.params;
	requires javafx.media;
	requires java.sql;
	
	opens application to javafx.graphics, javafx.fxml,javafx.base;
	opens models to javafx.graphics, javafx.fxml,javafx.base;
	opens layouts to javafx.graphics, javafx.fxml,javafx.base;
}
