package io.github.hardlitchi.rest.common.util;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Map;
import java.util.TimeZone;

import org.springframework.stereotype.Component;

import io.github.hardlitchi.rest.common.constant.TimeSpan;

/**
 * 【ユーティリティクラス】
 * <br>
 * 日時を取り扱う.
 * @author hardlitchi
 * @version 1.0
 */
@Component
public class TimestampUtil {

	/** 朝の開始時間. */
	private static Timestamp START_MORNING;
	/** 昼の開始時間. */
	private static Timestamp START_NOON;
	/** 夜の開始時間. */
	private static Timestamp START_NIGHT;

	TimestampUtil() {
		Calendar now = Calendar.getInstance();
		now.setTimeZone(TimeZone.getDefault());
		now.set(Calendar.MINUTE, 0);
		now.set(Calendar.SECOND, 0);
		now.set(Calendar.MILLISECOND, 0);

		now.set(Calendar.HOUR_OF_DAY, 6);
		START_MORNING = new Timestamp(((Calendar) now.clone()).getTimeInMillis());

		now.set(Calendar.HOUR_OF_DAY, 10);
		START_NOON = new Timestamp(((Calendar) now.clone()).getTimeInMillis());

		now.set(Calendar.HOUR_OF_DAY, 17);
		START_NIGHT = new Timestamp(((Calendar) now.clone()).getTimeInMillis());
	}

	/**
	 * 現在日時を返却する.
	 * @return 現在日時
	 */
	public Timestamp now() {
		Calendar now = Calendar.getInstance();
		now.setTimeZone(TimeZone.getDefault());
		return new Timestamp(((Calendar) now.clone()).getTimeInMillis());
	}

	/**
	 * 日時の加減算を行う.
	 * @param target 加減算対象
	 * @param field 加減算対象
	 * @param value 加減算量
	 * @return 加減算結果
	 */
	public Timestamp add(Timestamp target, int field, int value) {
		Calendar tmp = Calendar.getInstance();
		tmp.setTime(target);
		tmp.set(field, tmp.get(field) + value);

		return new Timestamp(tmp.getTime().getTime());
	}

	/**
	 * 日時の加減算を行う.
	 * @param target 加減算対象
	 * @param map 加減算対象と加減算量
	 * @return 加減算結果
	 */
	public Timestamp add(Timestamp target, Map<Integer, Integer> map) {
		Calendar tmp = Calendar.getInstance();
		tmp.setTime(target);
		for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
			tmp.set(entry.getKey(), tmp.get(entry.getKey()) + entry.getValue());
		}

		return new Timestamp(tmp.getTime().getTime());
	}

	/**
	 * 時間帯を判定する.
	 * @param now 判定対象時刻
	 * @return 判定結果
	 */
	public TimeSpan timespan(Timestamp now) {

		if (START_MORNING.compareTo(now)  <= 0
				&& START_NOON.compareTo(now) > 0) {
			return TimeSpan.MORNING;
		}

		if (START_NOON.compareTo(now)  <= 0
				&& START_NIGHT.compareTo(now) > 0) {
			return TimeSpan.NOON;
		}

		return TimeSpan.NIGHT;
	}
}
