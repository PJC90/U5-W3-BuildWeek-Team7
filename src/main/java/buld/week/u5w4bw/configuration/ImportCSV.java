package buld.week.u5w4bw.configuration;

import buld.week.u5w4bw.entities.Comune;
import buld.week.u5w4bw.entities.Province;
import buld.week.u5w4bw.services.ComuneService;
import buld.week.u5w4bw.services.ProvinceService;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.FileReader;
import java.io.IOException;

@Component
public class ImportCSV {

    private final ComuneService comuneService;
    private final ProvinceService provinceService;

    @Autowired
    public ImportCSV(ComuneService comuneService, ProvinceService provinceService) {
        this.comuneService = comuneService;
        this.provinceService = provinceService;
    }

    public void importDataFromCSV(String provinceFilename, String comuneFilename) {
        //importProvinceFromCSV(provinceFilename);
        //importComuniFromCSV(comuneFilename);
    }

    private void importProvinceFromCSV(String filename) {
        try (FileReader reader = new FileReader(filename);
             CSVParser csvParser = CSVFormat.DEFAULT.withDelimiter(';').withFirstRecordAsHeader().parse(reader)) {

            for (CSVRecord record : csvParser) {
                String provinceCode = record.get("Sigla");
                String name = record.get("Provincia");
                String regione = record.get("Regione");
                int code = Integer.parseInt(record.get("Code"));

                // Crea e salva l'oggetto Province nel db
                Province province = new Province();
                province.setNomeProvincia(name);
                province.setSigla(provinceCode);
                province.setRegione(regione);
                province.setProvinceCode(code);

                System.out.println(province);
                provinceService.saveProvince(province);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void importComuniFromCSV(String filename) {
        try (FileReader reader = new FileReader(filename);
             CSVParser csvParser = CSVFormat.DEFAULT.withDelimiter(';').withFirstRecordAsHeader().parse(reader)) {

            for (CSVRecord record : csvParser) {
                int provinciaCode = Integer.parseInt(record.get("Codice Provincia (Storico)(1)"));
                int comuneCode = Integer.parseInt(record.get("Progressivo del Comune (2)"));
                String nomeComune = record.get("Denominazione in italiano");

                // Trova la provincia corrispondente dal codice
                Province provincia = provinceService.findByProvinceCode(provinciaCode);

                // Crea e salva l'oggetto Comune nel database con l'ID della provincia corrispondente
                if (provincia != null) {
                    Comune comune = new Comune();
                    comune.setProvince(provincia);
                    comune.setComuneCode(comuneCode);
                    comune.setName(nomeComune);
                    comuneService.saveComune(comune);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
