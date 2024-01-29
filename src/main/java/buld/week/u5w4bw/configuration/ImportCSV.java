package buld.week.u5w4bw.configuration;

import buld.week.u5w4bw.entities.Comune;
import buld.week.u5w4bw.entities.Province;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.FileReader;
import java.io.IOException;

public class ImportCSV {

    private static void importProvinceFromCSV(String filename) {
        try (FileReader reader = new FileReader(filename);
             CSVParser csvParser = CSVFormat.DEFAULT.withDelimiter(';').withFirstRecordAsHeader().parse(reader)) {

            for (CSVRecord record : csvParser) {
                String provinceCode = record.get("Sigla");
                String name = record.get("Provincia");
                String regione = record.get("Regione");

                // Crea e salva l'oggetto Province nel database
                Province province = new Province();
                province.setNomeProvincia(name);
                province.setSigla(provinceCode);
                province.setRegione(regione);
                // Salva la provincia nel database utilizzando JPA o un'altra libreria di persistenza
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private static void importComuniFromCSV(String filename) {
        try (FileReader reader = new FileReader(filename);
             CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT.withDelimiter(';').withFirstRecordAsHeader())) {

            for (CSVRecord record : csvParser) {
                String provinciaCode = record.get("Codice Provincia (Storico)(1)");
                String comuneCode = record.get("Progressivo del Comune (2)");
                String nomeComune = record.get("Denominazione in italiano");

                // Crea e salva l'oggetto Comune nel database
                Comune comune = new Comune();
                comune.setProvinceCode(provinciaCode);
                comune.setComuneCode(comuneCode);
                comune.setName(nomeComune);
                // Salva il comune nel database utilizzando JPA o un'altra libreria di persistenza
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
