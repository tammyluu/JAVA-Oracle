package org.example.apispringbatch.tasklet;

import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

@Component
public class FileCleaningTasklet implements Tasklet {
    private final String filePath;


    public FileCleaningTasklet() {
        this.filePath ="/src/main/resources/films.csv";
    }

    @Override
    public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
        File file = new File(filePath);
        if(file.exists()){
            try(FileWriter writer = new FileWriter(file,false)){
                writer.write("");
            }catch (IOException e){
                throw new RuntimeException(e);
            }
        }
        return RepeatStatus.FINISHED;
    }
}
