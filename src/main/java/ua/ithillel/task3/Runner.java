package ua.ithillel.task3;

public class Runner {

    public void run() {
        MyPhone myPhone = new MyPhone();
        myPhone.switchOn();
        myPhone.call(3);

        System.out.println("__________________________\n");
        myPhone.camera.takePhoto();
        myPhone.camera.powerOn();
        myPhone.camera.takePhoto();
        myPhone.camera.powerOff();


    }
}
