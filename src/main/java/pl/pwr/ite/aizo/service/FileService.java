package pl.pwr.ite.aizo.service;

import pl.pwr.ite.aizo.model.AlgorithmType;
import pl.pwr.ite.aizo.model.SortResult;

import javax.print.DocFlavor;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;

public class FileService {

    private static final String DATA_PATH = "D:\\Workspace\\Personal\\aizo-project\\src\\main\\resources\\data\\";

    public void writeResults(List<SortResult> results) {
        var groupedResults = groupResults(results);
        for(var entry : groupedResults.entrySet()) {
            var algorithmType = entry.getKey();
            var result = entry.getValue();

            try(var writer = new BufferedWriter(new FileWriter(createFile(algorithmType), false))) {
                for(var res : result) {
                    writer.write(createLine(res));
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    private String createLine(SortResult result) {
        var sb = new StringBuilder();
        sb.append(result.getDataType()).append(",");
        if(result.getAlgorithmType().equals(AlgorithmType.Quick)) {
            sb.append(result.getPivotPosition()).append(",");
        }
        if(result.getAlgorithmType().equals(AlgorithmType.Shell)) {
            sb.append(result.getShellAlgorithmType()).append(",");
        }
        sb.append(result.getArrayType()).append(",");
        sb.append(result.getArraySize()).append(",");
        sb.append(result.getAverageTime()).append("\n");
        return sb.toString();
    }

    private File createFile(AlgorithmType algorithmType) {
        try {
            var file = new File(DATA_PATH + algorithmType.name() + ".csv");
            file.createNewFile();
            return file;
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    private Map<AlgorithmType, List<SortResult>> groupResults(List<SortResult> results) {
        return results.stream().collect(groupingBy(SortResult::getAlgorithmType));
    }
}
