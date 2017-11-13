package com.spring.batch;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.apache.commons.io.FileUtils;

import java.text.SimpleDateFormat;

public class FileArchivingTasklet implements Tasklet {

	 private File archiveDirectory;
     
	    private String archiveDirectoryPath = "D:/archivedFiles";
	     
	     
	    public void init(){
	        archiveDirectory = new File(archiveDirectoryPath);
	    }
	
	@Override
	public RepeatStatus execute(StepContribution contribution,  ChunkContext chunkContext)
			throws Exception {
		 	Map<String, Object> map = chunkContext.getStepContext().getJobParameters();
	        String fileName = (String) map.get("examResultInputFile");
	        archiveFile(fileName);
	        return RepeatStatus.FINISHED;
	}

	
	
	public void archiveFile(String fileName) throws IOException{
        System.out.println("Archiving file: "+fileName);
        File file = new File(fileName);
        File targetFile = new File(archiveDirectory, file.getName() + getSuffix());
        FileUtils.moveFile(file, targetFile);
    }
 
     
    public String getSuffix(){
        return "_" + new SimpleDateFormat("yyyyMMddHHmmss").format(new DateTime(DateTimeZone.UTC).toDate());
    } 
     

}
