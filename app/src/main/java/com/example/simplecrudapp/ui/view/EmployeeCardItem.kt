package com.example.simplecrudapp.ui.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.simplecrudapp.data.Employee

@Composable
fun EmployeeCardItem(employee: Employee) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 10.dp, start = 10.dp, end = 10.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface
        )
    ) {
        ConstraintLayout(
            modifier = Modifier.fillMaxWidth()
        ) {
            val verticalGuideline = createGuidelineFromStart(offset = 120.dp)
            val horizontalGuideline = createGuidelineFromTop(offset = 30.dp)
            val (txtFullName, txtAge, txtAgeValue, txtPosition, txtPositionValue, txtSalary, txtSalaryValue,
                txtCompany, txtCompanyValue) = createRefs()
            Text(
                modifier = Modifier.constrainAs(ref = txtFullName) {
                    top.linkTo(anchor = parent.top)
                    start.linkTo(anchor = parent.start)
                    end.linkTo(anchor = parent.end)
                },
                text = "${employee.firstName} ${employee.middleName} ${employee.lastName}"
            )
            Text(
                modifier = Modifier.constrainAs(ref = txtAge) {
                    top.linkTo(anchor = horizontalGuideline)
                    end.linkTo(anchor = verticalGuideline)
                    start.linkTo(anchor = parent.start)
                },
                text = "Возраст"
            )
            Text(
                modifier = Modifier.constrainAs(ref = txtAgeValue) {
                    top.linkTo(anchor = horizontalGuideline)
                    start.linkTo(anchor = verticalGuideline)
                },
                text = employee.age.toString()
            )
            Text(
                modifier = Modifier.constrainAs(ref = txtPosition) {
                    top.linkTo(anchor = txtAge.bottom)
                    end.linkTo(anchor = verticalGuideline)
                    start.linkTo(anchor = parent.start)
                },
                text = "Должность"
            )
            Text(
                modifier = Modifier.constrainAs(ref = txtPositionValue) {
                    top.linkTo(anchor = txtAgeValue.bottom)
                    start.linkTo(anchor = verticalGuideline)
                },
                text = employee.position.name
            )
            Text(
                modifier = Modifier.constrainAs(ref = txtSalary) {
                    top.linkTo(anchor = txtPosition.bottom)
                    end.linkTo(anchor = verticalGuideline)
                    start.linkTo(anchor = parent.start)
                },
                text = "Зарплата"
            )
            Text(
                modifier = Modifier.constrainAs(ref = txtSalaryValue) {
                    top.linkTo(anchor = txtPositionValue.bottom)
                    start.linkTo(anchor = verticalGuideline)
                },
                text = employee.position.salary.toString()
            )
            Text(
                modifier = Modifier.constrainAs(ref = txtCompany) {
                    top.linkTo(anchor = txtSalary.bottom)
                    end.linkTo(anchor = verticalGuideline)
                    start.linkTo(anchor = parent.start)
                },
                text = "Компания"
            )
            Text(
                modifier = Modifier.constrainAs(ref = txtCompanyValue) {
                    top.linkTo(anchor = txtSalaryValue.bottom)
                    start.linkTo(anchor = verticalGuideline)
                },
                text = employee.company.name
            )
        }
    }
}