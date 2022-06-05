package com.example.firebasekayit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.annotation.SuppressLint;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import com.example.firebasekayit.R;

import java.io.IOException;
import java.util.Set;
import java.util.UUID;

public class PulseMeasure extends AppCompatActivity {
    Button tryButton;
    String address = null, name = null;
    BluetoothAdapter bluetoothAdapter = null;
    BluetoothSocket bluetoothSocket = null;
    Set<BluetoothDevice> pairedDevices;
    static final UUID myUUID = UUID.fromString("00001101-0000-1000-8000-00805F9B34FB");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pulsemeasure);
        tryButton = findViewById(R.id.tryButton);
        try {
            run();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private void run() throws IOException {
        bluetooth_connect_device();
        tryButton.setOnClickListener(view -> send("Try Button"));
    }
    private void send(String operation){
        String value;
        try {
            if(bluetoothSocket!= null){
                if(operation.equals("Try Button")) {
                    value = "A";
                    bluetoothSocket.getOutputStream().write(value.getBytes());
                }
            }
        } catch (IOException e) {
            Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }
    private void receive(){
        String value;
        try {
            if(bluetoothSocket!= null){
                bluetoothSocket.getInputStream().read();
            }
        } catch (IOException e) {
            Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }
    @SuppressLint("HardwareIds")
    private void bluetooth_connect_device() throws IOException {
        try {
            bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.BLUETOOTH_CONNECT) != PackageManager.PERMISSION_GRANTED) {
                return;
            }
            address = bluetoothAdapter.getAddress();
            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.BLUETOOTH_CONNECT) != PackageManager.PERMISSION_GRANTED) {
                return;
            }
            pairedDevices = bluetoothAdapter.getBondedDevices();
            if (pairedDevices.size() > 0) {
                for (BluetoothDevice bluetoothDevice : pairedDevices) {
                    address = bluetoothDevice.getAddress();
                    Toast.makeText(getApplicationContext(), "Connected", Toast.LENGTH_SHORT).show();

                }
            }

        } catch (Exception we) {
            we.printStackTrace();
        }
        bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();//get the mobile bluetooth device
        BluetoothDevice bluetoothAdapterRemoteDevice = bluetoothAdapter.getRemoteDevice(address);//connects to the device's address and checks if it's available
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.BLUETOOTH_CONNECT) != PackageManager.PERMISSION_GRANTED) {

            return;
        }
        bluetoothSocket = bluetoothAdapterRemoteDevice.createInsecureRfcommSocketToServiceRecord(myUUID);//create a RFCOMM (SPP) connection
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.BLUETOOTH_CONNECT) != PackageManager.PERMISSION_GRANTED) {

            return;
        }
        bluetoothSocket.connect();
       /* try { t1.setText("BT Name: "+name+"\nBT Address: "+address); }
        catch(Exception e){}*/
    }
}
