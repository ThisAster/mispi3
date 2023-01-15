package beans;

import jakarta.enterprise.context.ApplicationScoped;

import jakarta.inject.Named;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import util.CustomFormatter;

import java.time.Instant;
import java.time.ZoneId;

@Named("attempt")
@ApplicationScoped
@NoArgsConstructor
@AllArgsConstructor
public class PointAttempt {

    private double x;
    private double y;
    private double r;
    @Setter @Getter
    private Instant attemptTime;
    @Setter @Getter
    private ZoneId zoneId;
    @Setter @Getter
    private double processTime;
    @Setter @Getter
    private boolean success;

    public void setPoint(Point point) {
        x = point.getX();
        y = point.getY();
        r = point.getR();
    }

    public Point getPoint() {
        return new Point(x, y, r);
    }

    public String getTimeStampFormatted() {
        return attemptTime.atZone(zoneId).format(CustomFormatter.getFormatterAtOffset(zoneId));
    }

}
