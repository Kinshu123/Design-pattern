interface Command {
    void execute();
}

class Light {
    public void on() {
        System.out.println("Light is on");
    }

    public void off() {
        System.out.println("Light is off");
    }
}

class Fan {
    public void start() {
        System.out.println("Fan started");
    }

    public void stop() {
        System.out.println("Fan stopped");
    }
}

class LightOnCommand implements Command {
    private Light light;

    public LightOnCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.on();
    }
}

class FanStartCommand implements Command {
    private Fan fan;

    public FanStartCommand(Fan fan) {
        this.fan = fan;
    }

    @Override
    public void execute() {
        fan.start();
    }
}

class RemoteControl {
    private Command command;

    public void setCommand(Command command) {
        this.command = command;
    }

    public void pressButton() {
        command.execute();
    }
}

public class SmartHomeCommandPattern {
    public static void main(String[] args) {
        Light light = new Light();
        Fan fan = new Fan();

        Command lightOnCommand = new LightOnCommand(light);
        Command fanStartCommand = new FanStartCommand(fan);

        RemoteControl remote = new RemoteControl();

        remote.setCommand(lightOnCommand);
        remote.pressButton();  // Light is on

        remote.setCommand(fanStartCommand);
        remote.pressButton();  // Fan started
    }
}
