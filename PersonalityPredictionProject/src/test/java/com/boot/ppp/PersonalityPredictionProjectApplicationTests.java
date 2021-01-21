package com.boot.ppp;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Rule;
import org.junit.jupiter.api.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.boot.ppp.beans.Jobs;
import com.boot.ppp.service.JobService;

@RunWith(SpringRunner.class)
@SpringBootTest
class PersonalityPredictionProjectApplicationTests {

		@Autowired
		JobService jobService;

		@SuppressWarnings("deprecation")
		@Rule
		public ExpectedException exceptionRule = ExpectedException.none();

		@Test
		void testSaveViewUpdateDeleteJob() throws Exception {

			// save record
			Jobs job = new Jobs();
			job.setJobDes("Java Developer");
			job.setReqSkills("Java");
			job.setExperience("3 years");
			job.setQualification("BSC.IT");

			// test after save
			jobService.addJobs(job);
			assertNotNull(job.getJobId());

			// view record
			Jobs jobs = jobService.getJobs(job.getJobId());
			assertEquals("Java Developer", jobs.getJobDes());
			assertEquals("Java", jobs.getReqSkills());
			assertEquals("3 years", jobs.getExperience());
			assertEquals("BSC.IT", jobs.getQualification());

			// update record
			job.setJobDes("Python Developer");
			jobService.updateJobs(job);

			// test after update
			jobs = jobService.getJobs(job.getJobId());
			assertEquals("Python Developer", jobs.getJobDes());
	}
	
}
