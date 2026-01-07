module com.ankitmahala07.benchmark_vtvscf {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.ankitmahala07.benchmark_vtvscf to javafx.fxml;
    exports com.ankitmahala07.benchmark_vtvscf;
    exports com.ankitmahala07.benchmark_vtvscf.benchmark;
    opens com.ankitmahala07.benchmark_vtvscf.benchmark to javafx.fxml;
}