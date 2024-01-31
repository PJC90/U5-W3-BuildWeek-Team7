package buld.week.u5w4bw.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CSVRunner implements CommandLineRunner {


    private final ImportCSV importCSV;


    @Autowired
    public CSVRunner(ImportCSV importCSV) {
        this.importCSV = importCSV;
    }


    @Override
    public void run(String... args) throws Exception {

        String provinceFilename = "./CSV/province-italiane.csv";
        String comuneFilename = "./CSV/comuni-italiani.csv";


        importCSV.importDataFromCSV(provinceFilename, comuneFilename);


    }
}
