package frc.robot.commands;

import edu.wpi.first.networktables.DoublePublisher;
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj2.command.Command;

public class NetworkLoopOverrun extends Command {

    private long num;

    public NetworkLoopOverrun() {
    }

    DoublePublisher a, b, c, d, e, f, g, h, i, j, k, l, m, n, o, p, q, r, s, t, u, v, w, x, y, z;

    @Override
    public void initialize() {
        NetworkTable table = NetworkTableInstance.getDefault().getTable("test");

        a = table.getDoubleTopic("a").publish();
        b = table.getDoubleTopic("b").publish();
        c = table.getDoubleTopic("c").publish();
        d = table.getDoubleTopic("d").publish();
        e = table.getDoubleTopic("e").publish();
        f = table.getDoubleTopic("f").publish();
        g = table.getDoubleTopic("g").publish();
        h = table.getDoubleTopic("h").publish();
        i = table.getDoubleTopic("i").publish();
        j = table.getDoubleTopic("j").publish();
        k = table.getDoubleTopic("k").publish();
        l = table.getDoubleTopic("l").publish();
        m = table.getDoubleTopic("m").publish();
        n = table.getDoubleTopic("n").publish();
        o = table.getDoubleTopic("o").publish();
        p = table.getDoubleTopic("p").publish();
        q = table.getDoubleTopic("q").publish();
        r = table.getDoubleTopic("r").publish();
        s = table.getDoubleTopic("s").publish();
        t = table.getDoubleTopic("t").publish();
        u = table.getDoubleTopic("u").publish();
        v = table.getDoubleTopic("v").publish();
        w = table.getDoubleTopic("w").publish();
        x = table.getDoubleTopic("x").publish();
        y = table.getDoubleTopic("y").publish();
        z = table.getDoubleTopic("z").publish();
    }

    @Override
    public void execute() {
        a.set(num++);
        b.set(num++);
        c.set(num++);
        d.set(num++);
        e.set(num++);
        f.set(num++);
        g.set(num++);
        h.set(num++);
        i.set(num++);
        j.set(num++);
        k.set(num++);
        l.set(num++);
        m.set(num++);
        n.set(num++);
        o.set(num++);
        p.set(num++);
        q.set(num++);
        r.set(num++);
        s.set(num++);
        t.set(num++);
        u.set(num++);
        v.set(num++);
        w.set(num++);
        x.set(num++);
        y.set(num++);
        z.set(num++);
    }

    @Override
    public boolean isFinished() {
        return false;
    }

    @Override
    public String toString() {
        return "Network Loop Overrun";
    }
}
