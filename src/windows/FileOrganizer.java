package windows;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class FileOrganizer {

    public void organize(String directory) {
        

        try {
            organizeFilesByName(directory);
            organizeFilesByDate(directory);
            organizeFilesByType(directory);
            organizeFilesBySize(directory);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void organizeFilesByName(String sourceDirectory) throws IOException {
        List<Path> sortedFiles = Files.list(Paths.get(sourceDirectory))
                .sorted(Comparator.comparing(Path::getFileName))
                .collect(Collectors.toList());

        for (Path file : sortedFiles) {
            Files.move(file, file.resolveSibling(file.getFileName()), StandardCopyOption.REPLACE_EXISTING);
        }
    }

    public void organizeFilesByDate(String sourceDirectory) throws IOException {
        List<Path> sortedFiles = Files.find(Paths.get(sourceDirectory), Integer.MAX_VALUE, (filePath, fileAttr) -> fileAttr.isRegularFile())
                .sorted(Comparator.comparingLong(path -> {
                    try {
                        return Files.getLastModifiedTime(path).toMillis();
                    } catch (IOException e) {
                        throw new RuntimeException("Error reading file attributes", e);
                    }
                }))
                .collect(Collectors.toList());

        for (Path file : sortedFiles) {
            Files.move(file, file.resolveSibling(file.getFileName()), StandardCopyOption.REPLACE_EXISTING);
        }
    }

    public void organizeFilesByType(String sourceDirectory) throws IOException {
        List<Path> sortedFiles = Files.list(Paths.get(sourceDirectory))
                .sorted(Comparator.comparing(path -> {
                    try {
                        return Files.probeContentType(path);
                    } catch (IOException e) {
                        throw new RuntimeException("Error reading file attributes", e);
                    }
                }))
                .collect(Collectors.toList());

        for (Path file : sortedFiles) {
            Files.move(file, file.resolveSibling(file.getFileName()), StandardCopyOption.REPLACE_EXISTING);
        }
    }

    public void organizeFilesBySize(String sourceDirectory) throws IOException {
        List<Path> sortedFiles = Files.list(Paths.get(sourceDirectory))
                .sorted(Comparator.comparingLong(path -> {
                    try {
                        return Files.size(path);
                    } catch (IOException e) {
                        throw new RuntimeException("Error reading file attributes", e);
                    }
                }))
                .collect(Collectors.toList());

        for (Path file : sortedFiles) {
            Files.move(file, file.resolveSibling(file.getFileName()), StandardCopyOption.REPLACE_EXISTING);
        }
    }
}
