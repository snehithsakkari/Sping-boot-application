/**
 * 
 */
package com.shs.employeesvc.resources;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import com.shs.employeesvc.models.*;

/**
 * @author snehithgoud
 *
 */

@RestController
@RequestMapping("/employee")
public class EmployeeResource {
	
	@RequestMapping("/{userId}")
	public EmployeeInformation getEmployee(@PathVariable("userId")String userId){
		return new EmployeeInformation("890", "sak", "snehith", "03/29/1993");
	}

}
