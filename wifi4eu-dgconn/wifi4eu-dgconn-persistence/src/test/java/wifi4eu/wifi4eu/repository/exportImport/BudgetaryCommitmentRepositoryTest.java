package wifi4eu.wifi4eu.repository.exportImport;

import com.github.springtestdbunit.TransactionDbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseOperation;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.github.springtestdbunit.annotation.DatabaseTearDown;
import com.github.springtestdbunit.annotation.DbUnitConfiguration;
import com.github.springtestdbunit.operation.MicrosoftSqlDatabaseOperationLookup;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:testContext.xml")
@Transactional
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class,
        DirtiesContextTestExecutionListener.class,
        TransactionDbUnitTestExecutionListener.class })
@DbUnitConfiguration(databaseConnection = "dataSource", databaseOperationLookup = MicrosoftSqlDatabaseOperationLookup.class)
@DatabaseSetup("classpath:data/budgetaryCommitment.xml")
@DatabaseTearDown("classpath:data/budgetaryCommitment.xml")
@DirtiesContext(classMode= DirtiesContext.ClassMode.AFTER_CLASS)
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