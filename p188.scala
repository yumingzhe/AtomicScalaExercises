import java.text.SimpleDateFormat

import com.atomicscala.AtomicTest._
import org.apache.commons.math3.stat.Frequency
import org.apache.commons.math3.stat.descriptive.SummaryStatistics

// 运行本测试代码时，需要将commons-math3.jar加入到classpath中

// 1.
val datePattern = new SimpleDateFormat("MM/dd/yy")
val mayDay = datePattern.parse("05/01/12")
mayDay.getDate is 1
mayDay.getMonth is 4

// 2.
// mm表示分钟
val datePattern2 = new SimpleDateFormat("mm/dd/yy")
val mayDay2 = datePattern2.parse("05/01/12")
mayDay2.getDate is 1
// error, mayDay 2 is 2012-01-01
//mayDay2.getMonth is 4

// 3.
// java日期中，月份是从0开始，日期是从1开始

// 4.
val f = new Frequency
f.addValue("cat")
f.addValue("dog")
f.addValue("cat")
f.addValue("bird")
f.addValue("cat")
f.addValue("cat")
f.addValue("kitten")
f.addValue("mouse")
f.getCount("cat") is 4
// 5.
val s = new SummaryStatistics
s.addValue(10)
s.addValue(20)
s.addValue(30)
s.addValue(80)
s.addValue(90)
s.addValue(100)
s.getMean is 55
s.getStandardDeviation is 39.370039370059054
