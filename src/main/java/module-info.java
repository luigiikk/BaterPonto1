module br.luigi.baterponto1 {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires com.almasb.fxgl.all;

    opens br.luigi.baterponto1 to javafx.fxml;
    exports br.luigi.baterponto1;
    exports br.luigi.baterponto1.controller;
    opens br.luigi.baterponto1.controller to javafx.fxml;
    exports model;
    opens model to javafx.fxml;
}