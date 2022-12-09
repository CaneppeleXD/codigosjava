package br.univates.source;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;

import net.sf.jasperreports.engine.data.JsonDataSource;

import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.query.JsonQueryExecuterFactory;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

public class ProgramaTesteJasper {
    public static void main(String[] args) throws JRException, IOException {

        if (args.length>0){
            System.out.println(args[0]);
        }
        //carrega e compila o relatorio

        String path = "/home/flexabus-java-3/pasta do jao/javaas/Source/src/main/java/br/univates/source/report/Coffee_2.jrxml";
        JasperDesign jasperDesign = JRXmlLoader.load(path);
        JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);
        

        //carrega o arquivo json com os dadoss
        File jsonFile = new File("/home/flexabus-java-3/L.json");
        Map parametros = new HashMap();
        parametros.put(JsonQueryExecuterFactory.JSON_INPUT_STREAM, new FileInputStream(jsonFile));
        
        //preenche o relatorio
        jasperReport.setProperty("net.sf.jasperreports.awt.ignore.missing.font", "true");
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport,parametros);

        //salva e mostra o relatorio

        JasperExportManager.exportReportToPdfFile(jasperPrint, "BasicReport.pdf");
        JasperViewer.viewReport(jasperPrint);

    }    
}
