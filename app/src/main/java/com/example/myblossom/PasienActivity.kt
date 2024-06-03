package com.example.myblossom


import android.os.Bundle
import android.widget.Button
import android.widget.DatePicker
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.play.integrity.internal.c
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.*
import java.util.concurrent.TimeUnit


class PasienActivity : AppCompatActivity() {

    //lateinit var datePickerx: DatePicker
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pasien)

        val datePickerx = findViewById<DatePicker>(R.id.editText_date)

        val tanggalx = findViewById<EditText>(R.id.tanggalText)

        val day: Int = datePickerx.getDayOfMonth()
        val month: Int = datePickerx.getMonth() + 1
        val year: Int = datePickerx.getYear()

        val cday: Int = datePickerx.getDayOfMonth()
        val cmonth: Int = datePickerx.getMonth() + 1
        val cyear: Int = datePickerx.getYear()

        // val tanggal = datePickerx.getDate()

        val sdf = SimpleDateFormat("yyyy-MM-dd")
        val currentDate = sdf.format(Date())


        // showDatePicker()
        tanggalx.setText(currentDate)

//        @RequiresApi(Build.VERSION_CODES.O)
//        fun getDaysDif(fromDate: LocalDate, toDate: LocalDate): Long {
//            return ChronoUnit.DAYS.between(fromDate, toDate)
//        }

        val jumday: Int = 0

        fun handleSuccessa(a: String) {
            val sdfa = SimpleDateFormat("dd/MM/yyyy")
            val datefirst = sdfa.parse(a)
            val calendar = Calendar.getInstance()
            calendar.setTime(datefirst);
            calendar.add(Calendar.DAY_OF_YEAR, 42)
            val sdf1 = SimpleDateFormat("dd/MM/yyyy")
            val outputx = sdf1.format(calendar.getTime())




            Toast.makeText(
                this@PasienActivity,
                "6 minggu pertama sejak pertama kehamilan dari tanggal " + a + "sampai dengan " + outputx,
                Toast.LENGTH_SHORT
            ).show()
            tanggalx.setText("minggu ke 12 hingga ke 24  sejak pertama kehamilan dari tanggal " + a + "sampai dengan " + outputx)
        }

        fun handleSuccessb(a: String) {

            val sdfa = SimpleDateFormat("dd/MM/yyyy")
            val datefirst = sdfa.parse(a)
            val calendar = Calendar.getInstance()
            calendar.setTime(datefirst);
            calendar.add(Calendar.DAY_OF_YEAR, 42)
            val sdf1 = SimpleDateFormat("dd/MM/yyyy")
            val outputx = sdf1.format(calendar.getTime())

            calendar.setTime(datefirst);
            calendar.add(Calendar.DAY_OF_YEAR, 84)
            val outputy = sdf1.format(calendar.getTime())


            Toast.makeText(
                this@PasienActivity,
                "minggu ke 6 hingga ke 12  sejak pertama kehamilan dari tanggal " + outputx + "sampai dengan " + outputy,
                Toast.LENGTH_SHORT
            ).show()
            tanggalx.setText("minggu ke 12 hingga ke 24  sejak pertama kehamilan dari tanggal " + outputx + "sampai dengan " + outputy)
        }

        fun handleSuccessc(a: String) {
            val sdfa = SimpleDateFormat("dd/MM/yyyy")
            val datefirst = sdfa.parse(a)
            val calendar = Calendar.getInstance()
            calendar.setTime(datefirst);
            calendar.add(Calendar.DAY_OF_YEAR, 84)
            val sdf1 = SimpleDateFormat("dd/MM/yyyy")
            val outputx = sdf1.format(calendar.getTime())

            calendar.setTime(datefirst);
            calendar.add(Calendar.DAY_OF_YEAR, 168)
            val outputy = sdf1.format(calendar.getTime())


            Toast.makeText(
                this@PasienActivity,
                "minggu ke 12 hingga ke 24  sejak pertama kehamilan dari tanggal " + outputx + "sampai dengan " + outputy,
                Toast.LENGTH_SHORT
            ).show()
            tanggalx.setText("minggu ke 12 hingga ke 24  sejak pertama kehamilan dari tanggal " + outputx + "sampai dengan " + outputy)
            //Toast.makeText(this@PasienActivity, "minggu ke 12 hingga ke 24  sejak pertama kehamilan" , Toast.LENGTH_SHORT).show()
        }

        fun handleSuccessd(a: String) {

            val sdfa = SimpleDateFormat("dd/MM/yyyy")
            val datefirst = sdfa.parse(a)
            val calendar = Calendar.getInstance()
            calendar.setTime(datefirst);
            calendar.add(Calendar.DAY_OF_YEAR, 168)
            val sdf1 = SimpleDateFormat("dd/MM/yyyy")
            val outputx = sdf1.format(calendar.getTime())

            calendar.setTime(datefirst);
            calendar.add(Calendar.DAY_OF_YEAR, 280)
            val outputy = sdf1.format(calendar.getTime())


            Toast.makeText(
                this@PasienActivity,
                " 3x pemeriksaan minggu ke 12 hingga ke 24  sejak pertama kehamilan dari tanggal " + outputx + "sampai dengan " + outputy,
                Toast.LENGTH_SHORT
            ).show()
            tanggalx.setText("minggu ke 12 hingga ke 24  sejak pertama kehamilan dari tanggal " + outputx + "sampai dengan " + outputy)

            //Toast.makeText(this@PasienActivity, "3x pemeriksaan dari minggu ke 24 hingga ke 40  sejak pertama kehamilan" , Toast.LENGTH_SHORT).show()
        }


        val today = Calendar.getInstance()
        datePickerx.init(
            today.get(Calendar.YEAR), today.get(Calendar.MONTH),
            today.get(Calendar.DAY_OF_MONTH)

        ) { view, year, month, day ->
            val month = month + 1
            val diffm = cmonth - month
            val msg = "$day/$month/$year"
            tanggalx.setText(msg)
            val diffmonth = "$diffm"


            val dateStr = "$day/$month/$year"
            val sdfa = SimpleDateFormat("dd/MM/yyyy")
            val datesatu = sdfa.parse(dateStr)
            val cudate = sdfa.parse("$cday/$cmonth/$cyear")

            val diff: Long = cudate.getTime() - datesatu.getTime()
            val jumday = TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS).toInt()

            //val jumdayin = jumday.toInt()


            when {
                jumday < 42 -> handleSuccessa(msg)
                jumday < 84 -> handleSuccessb(msg)
                jumday < 98 -> handleSuccessc(msg)
                else -> handleSuccessd(msg)
            }


            //Toast.makeText(this@PasienActivity, "Days: " + jumday, Toast.LENGTH_SHORT).show()


            //Toast.makeText(this@PasienActivity, diffmonth, Toast.LENGTH_SHORT).show()
        }


        val validateBtnx = findViewById<Button>(R.id.validateBtnx)
        validateBtnx.setOnClickListener {

            var bill = tanggalx.getText()
            Toast.makeText(
                this@PasienActivity,
                "2 kali pada trimester pertama (usia kehamilan hingga 12 minggu) " + bill,
                Toast.LENGTH_SHORT
            ).show()
            //showDatePicker()


        }
    }

    fun DatePicker.getDate(): Date {
        val calendar = Calendar.getInstance()
        calendar.set(year, month, dayOfMonth)
        return calendar.time
    }
    /*
        fun showDatePicker() {
            // DatePicker

            billDateEditText.setText(SimpleDateFormat("dd/MM/yyyy").format(System.currentTimeMillis()))

            var cal = Calendar.getInstance()

            val dateSetListener = DatePickerDialog.OnDateSetListener { view, year, monthOfYear, dayOfMonth ->
                cal.set(Calendar.YEAR, year)
                cal.set(Calendar.MONTH, monthOfYear)
                cal.set(Calendar.DAY_OF_MONTH, dayOfMonth)

                val myFormat = "dd/MM/yyyy" // mention the format you need
                val sdf = SimpleDateFormat(myFormat, Locale.US)
                billDateEditText.setText(sdf.format(cal.time))
            }

            billDateEditText.setOnClickListener {

                Log.d("Clicked", "Interview Date Clicked")

                val dialog = DatePickerDialog(this, dateSetListener,
                    cal.get(Calendar.YEAR),
                    cal.get(Calendar.MONTH),
                    cal.get(Calendar.DAY_OF_MONTH))
                dialog.datePicker.maxDate = CalendarHelper.getCurrentDateInMills()
                dialog.show()
            }



        }*/


}