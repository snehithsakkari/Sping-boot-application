package com.shs.employeesvc.repository;



import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBSaveExpression;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.ComparisonOperator;
import com.amazonaws.services.dynamodbv2.model.ConditionalCheckFailedException;
import com.amazonaws.services.dynamodbv2.model.ExpectedAttributeValue;
import com.shs.employeesvc.models.EmployeeInformation;



@Repository
public class EmployeeRepository {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeRepository.class);
	
	@Autowired
	private DynamoDBMapper mapper;
	
	
	public void insertIntoDynamoDB(EmployeeInformation employee) {
		mapper.save(employee);
	}
	
	public EmployeeInformation getOneEmployeeDetails(String employeeId, String lastName) {
		return mapper.load(EmployeeInformation.class, employeeId, lastName );
	}
	
	public void updateEmployeeDetails(EmployeeInformation employee) {
		try {
			mapper.save(employee, buildDynamoDBSaveExpression(employee));
		} catch(ConditionalCheckFailedException exception) {
			LOGGER.error("invalid data -" +exception.getMessage());
		}
	}
	
	public void deleteEmployeeDetails(EmployeeInformation employee) {
		mapper.delete(employee);
	}
	
	
	public DynamoDBSaveExpression buildDynamoDBSaveExpression(EmployeeInformation employee) {
		DynamoDBSaveExpression saveExpression = new DynamoDBSaveExpression();
		Map<String, ExpectedAttributeValue> expected = new HashMap<>();
		expected.put("employeeId", new ExpectedAttributeValue(new AttributeValue(employee.getId())))
				.withComparisonOperator(ComparisonOperator.EQ);
		saveExpression.setExpected(expected);
		
		return saveExpression;
		
	}

}
