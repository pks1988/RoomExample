package com.room.jetpack;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

import com.room.jetpack.entities.Student;
import com.room.jetpack.viewmodels.StudentViewModel;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RegisterStudentActivity extends AppCompatActivity {

    @BindView(R.id.txtInputName)
    TextInputLayout txtInputName;
    @BindView(R.id.edtFName)
    TextInputEditText edtFName;
    @BindView(R.id.textInputFName)
    TextInputLayout textInputFName;
    @BindView(R.id.edtMName)
    TextInputEditText edtMName;
    @BindView(R.id.txtInputMName)
    TextInputLayout txtInputMName;
    @BindView(R.id.imageButton)
    ImageButton imageButton;
    @BindView(R.id.edtPostalAddress)
    EditText edtPostalAddress;
    @BindView(R.id.radioMale)
    RadioButton radioMale;
    @BindView(R.id.radioFemale)
    RadioButton radioFemale;
    @BindView(R.id.radioGroup)
    RadioGroup radioGroup;
    @BindView(R.id.spnCity)
    Spinner spnCity;
    @BindView(R.id.spnCourse)
    Spinner spnCourse;
    @BindView(R.id.edtEmail)
    TextInputEditText edtEmail;
    @BindView(R.id.txt_InputEmail)
    TextInputLayout txtInputEmail;
    @BindView(R.id.edtMobile)
    TextInputEditText edtMobile;
    @BindView(R.id.txtInputMobile)
    TextInputLayout txtInputMobile;
    @BindView(R.id.btnSubmit)
    Button btnSubmit;
    @BindView(R.id.edtName)
    TextInputEditText edtName;
    @BindView(R.id.edtDate)
    EditText edtDate;

    public static final String REPLY_EXTRA="student";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

    }

    private void insertStudents() {
        Student mStudent = new Student();
        mStudent.setStudentName(edtName.getText().toString().trim());
        mStudent.setFatherName(edtFName.getText().toString().trim());
        mStudent.setMotherName(edtMName.getText().toString().trim());
        mStudent.setGender(getGender());
        mStudent.setDob(edtDate.getText().toString().trim());
        mStudent.setAddress(edtPostalAddress.getText().toString().trim());
        mStudent.setCity(spnCity.getSelectedItem().toString());
        mStudent.setCourse(spnCourse.getSelectedItem().toString());
        mStudent.setEmail(edtEmail.getText().toString().trim());
        mStudent.setPhone(edtMobile.getText().toString().trim());

        saveInDatabase(mStudent);
    }

    private void saveInDatabase(Student mStudent) {
        Intent resultIntent = new Intent();
        if (mStudent != null) {
            resultIntent.putExtra(REPLY_EXTRA, mStudent);
            setResult(RESULT_OK, resultIntent);
        } else {
            setResult(RESULT_CANCELED, resultIntent);
        }
        finish();
    }

    public String getGender() {
        int radioBtnId = radioGroup.getCheckedRadioButtonId();
        if (radioBtnId == R.id.radioFemale) {
            return radioFemale.getText().toString();
        } else {
            return radioMale.getText().toString();
        }
    }

    public void registerStudent(View view) {
        insertStudents();
    }
}
