package com.example.myapplication5.Bluetooth

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myapplication5.R
import com.example.myapplication5.databinding.ActivityTestBinding
import android.bluetooth.BluetoothAdapter
import android.bluetooth.BluetoothDevice
import android.bluetooth.BluetoothManager
import android.content.Intent
import android.content.pm.PackageManager
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat


class testActivity : AppCompatActivity() {

/*
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test)

        val binding = ActivityTestBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val bluetoothManager: BluetoothManager = getSystemService(BluetoothManager::class.java)
        val bluetoothAdapter: BluetoothAdapter? = bluetoothManager.getAdapter()
        //블루투스어댑터 체크
        if (bluetoothAdapter == null) {
            // Device doesn't support Bluetooth
            Toast
                .makeText(this, "블루투스 미지원 기기입니다", Toast.LENGTH_SHORT)
                .show()
        }
        // ActivityResultContract를 정의
        val enableBtContract = ActivityResultContracts.StartActivityForResult()

        // 이 부분은 결과를 처리하는 ActivityResultCallback입니다.
        val enableBtCallback = registerForActivityResult(enableBtContract) { result ->
            if (result.resultCode == Activity.RESULT_OK) {
                // 블루투스가 성공적으로 활성화되었을 때의 코드를 여기에 추가하세요
                println("블루투스가 활성화되었습니다")
            } else {
                // 블루투스가 활성화되지 않았을 때의 코드를 여기에 추가하세요
                println("블루투스가 활성화를 실패했습니다.")
            }
        }

        // 이 부분은 ActivityResultContract를 정의합니다.
        val disableBtContract = ActivityResultContracts.StartActivityForResult()

        // 이 부분은 결과를 처리하는 ActivityResultCallback입니다.
        val disableBtCallback = registerForActivityResult(disableBtContract) { result ->
            if (result.resultCode == Activity.RESULT_OK) {
                // 블루투스가 성공적으로 비활성화되었을 때의 코드를 여기에 추가하세요
                Toast.makeText(this, "블루투스 비활성화", Toast.LENGTH_SHORT).show()
            } else {
                // 블루투스가 비활성화되지 않았을 때의 코드를 여기에 추가하세요
                Toast.makeText(this, "블루투스 비활성화에 실패했습니다.", Toast.LENGTH_SHORT).show()
            }
        }


        binding.switch2.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                // 스위치가 켜진 경우
                if (bluetoothAdapter?.isEnabled == false) {
                    val enableBtIntent = Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE)
                    enableBtCallback.launch(enableBtIntent)
                    Toast.makeText(this, "블루투스 on", Toast.LENGTH_SHORT).show()
                }
            } else {
                // 스위치가 꺼진 경우
                if (bluetoothAdapter?.isEnabled == true) {
                   // bluetoothAdapter?.disable()
                    Toast.makeText(this, "블루투스 off", Toast.LENGTH_SHORT).show()
                }
            }
        }

        // 페어링된 디바이스 검색
        fun getPairedDevices() {
            bluetoothAdapter?.let {
                // 블루투스 활성화 상태라면
                if (it.isEnabled) {
                    // ArrayAdapter clear
                    adapter.clear()
                    // 페어링된 기기 확인
                    val pairedDevices: Set<BluetoothDevice> = it.bondedDevices
                    // 페어링된 기기가 존재하는 경우
                    if (pairedDevices.isNotEmpty()) {
                        pairedDevices.forEach { device ->
                            // ArrayAdapter에 아이템 추가
                            adapter.add(Pair(device.name, device.address))
                        }
                    } else {
                        showMessage(this, "페어링된 기기가 없습니다.")
                    }
                } else {
                    showMessage(this, "블루투스가 비활성화 되어 있습니다.")
                }
            }
        }


    }*/
}
