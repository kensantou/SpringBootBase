package com.santy.model.mydata;

import com.ninja_squad.dbsetup.DbSetup;
import com.ninja_squad.dbsetup.Operations;
import com.ninja_squad.dbsetup.destination.DataSourceDestination;
import com.ninja_squad.dbsetup.destination.Destination;
import com.ninja_squad.dbsetup.operation.Operation;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MyDataServiceTest {

    public static final Operation DELETE_ALL =
            Operations.deleteAllFrom("mydata");

    public static final Operation INSERT =
            Operations.insertInto("mydata")
                    .columns("id", "name")
                    .values("1","Tanaka")
                    .values("2","Yoshida")
                    .values("3","Suzuki")
                    .build();

    @Autowired
    DataSource dataSource;

    @Before
    public void before(){
        Destination dest = new DataSourceDestination(dataSource);
        Operation ops = Operations.sequenceOf(DELETE_ALL, INSERT, DELETE_ALL);
        DbSetup dbSetup = new DbSetup(dest, ops);
        dbSetup.launch();
    }

    @Autowired
    MyDataService myDataService;

    @Test
    public void findAll() throws Exception {
        List<MyData> myData = myDataService.findAll();
        assertThat(myData.get(0).getId(),is(1));
        assertThat(myData.get(0).getName(),is("Tanaka"));
    }

}