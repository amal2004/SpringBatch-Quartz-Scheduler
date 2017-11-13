package com.spring.batch;

import org.springframework.batch.item.ItemProcessor;

import com.spring.batch.model.ExamResult;

public class ExamResultItemProcessor implements ItemProcessor<ExamResult, ExamResult>{

	
	@Override
	public ExamResult process(ExamResult result) throws Exception {
		System.out.println("Processing result :"+result);
		
		/*
		 * Only return results which are more than 60%
		 * 
		 */
		if(result.getPercentage() < 75){
			return null;
		}
		
		return result;
	}

}
