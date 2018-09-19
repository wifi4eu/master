package wifi4eu.wifi4eu.repository.exportImport;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:testContext.xml")
public class BudgetaryCommitmentRepositoryTest {

    @Autowired
    BudgetaryCommitmentRepository budgetaryCommitmentRepository;

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    @Ignore
    public void totalSpentForGlobalCommitment() {

        budgetaryCommitmentRepository.totalSpentForGlobalCommitment(1);

        assertEquals("Incorrect total ammount for commitment", 45000, budgetaryCommitmentRepository.totalSpentForGlobalCommitment(1));
    }
}