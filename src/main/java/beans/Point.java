package beans;

import jakarta.enterprise.context.ApplicationScoped;

import jakarta.inject.Inject;
import jakarta.inject.Named;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

import java.time.Instant;


@Named("point")
@ApplicationScoped
@AllArgsConstructor
@NoArgsConstructor
public class Point implements Serializable {

    @Inject
    transient private AreaChecker areaChecker;
    @Inject
    transient private Model model;
    @Getter @Setter
    private double x;
    @Getter @Setter
    private double y;
    @Getter @Setter
    private double r;

    public Point(double x, double y, double r) {
        this.x = x;
        this.y = y;
        this.r = r;
    }

    public void submit() {
        final long start = System.nanoTime();
        final boolean res = areaChecker.checkPoint(this);

        PointAttempt attempt = new PointAttempt();
        attempt.setPoint(this);
        attempt.setSuccess(res);
        attempt.setAttemptTime(Instant.now());
        attempt.setProcessTime((System.nanoTime() - start) / 1000d);
        model.add(attempt);
        System.out.println(attempt);
    }

}
