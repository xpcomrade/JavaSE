package my.javase.study.java8.datetime;

import org.junit.Test;

import java.time.*;

/**
 * Created by xpcomrade on 10/26/15.
 */
public class Main {
    /**
     *  Clock它通过指定一个时区，然后就可以获取到当前的时刻，日期与时间。
     *  Clock可以替换System.currentTimeMillis()与TimeZone.getDefault()。
     */
    @Test
    public void testClock() {
        // Get the system clock as UTC offset
        java.time.Clock clock = java.time.Clock.systemUTC();
        System.out.println("instant：" + clock.instant());
        System.out.println("millis：" + clock.millis());
    }

    /**
     * LocaleTime只持有ISO-8601格式且无时区信息的时间部分
     */
    @Test
    public void testLocalTime () {
        java.time.Clock clock = java.time.Clock.systemUTC();
        LocalTime time = LocalTime.now(clock);
        System.out.println(time);
    }

    /**
     * LocaleDate只持有ISO-8601格式且无时区信息的日期部分
     */
    @Test
    public void testLocalDate () {
        java.time.Clock clock = java.time.Clock.systemUTC();
        LocalDate date = LocalDate.now(clock);
        System.out.println(date);
    }

    /**
     * LocaleDateTime把LocaleDate与LocaleTime的功能合并起来，它持有的是ISO-8601格式无时区信息的日期与时间
     */
    @Test
    public void testLocalDateTime () {
        java.time.Clock clock = java.time.Clock.systemUTC();
        LocalDateTime dateTime = LocalDateTime.now(clock);
        System.out.println(dateTime);
    }

    /**
     * ZonedDateTime它持有ISO-8601格式具具有时区信息的日期与时间
     */
    @Test
    public void testZonedDateTime () {
        java.time.Clock clock = java.time.Clock.systemUTC();
        final ZonedDateTime zonedDatetime = ZonedDateTime.now();
        final ZonedDateTime zonedDatetimeFromClock = ZonedDateTime.now( clock );
        final ZonedDateTime zonedDatetimeFromZone = ZonedDateTime.now(ZoneId.of("Asia/Shanghai"));
        System.out.println( zonedDatetime );
        System.out.println( zonedDatetimeFromClock );
        System.out.println( zonedDatetimeFromZone );
    }

    @Test
    public void testDuration() {
        // Get duration between two dates
        final LocalDateTime from = LocalDateTime.of( 2014, Month.APRIL, 16, 0, 0, 0 );
        final LocalDateTime to = LocalDateTime.of( 2015, Month.APRIL, 16, 23, 59, 59 );

        final Duration duration = Duration.between(from, to);
        System.out.println( "Duration in days: " + duration.toDays() );
        System.out.println( "Duration in hours: " + duration.toHours() );

    }
















}
