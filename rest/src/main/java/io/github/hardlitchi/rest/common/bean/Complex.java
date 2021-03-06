package io.github.hardlitchi.rest.common.bean;

import lombok.Data;

/**
 * 【Beanクラス】
 * <br>
 * 複素数クラス.
 * @author hardlitchi
 * @version 1.0
 */
@Data
public class Complex {

	/** 実数部. */
	private double real;
	/** 虚数部. */
	private double image;

	/**
	 * 加算.
	 * @param complex 複素数
	 * @return 加算結果
	 */
	public Complex add(Complex complex) {
		this.real += complex.real;
		this.image += complex.image;

		return this;
	}

	/**
	 * 減算.
	 * @param complex 複素数
	 * @return 減算結果
	 */
	public Complex minus(Complex complex) {
		this.real -= complex.real;
		this.image -= complex.image;

		return this;
	}

	/**
	 * 乗算.
	 * @param complex 複素数
	 * @return 乗算結果
	 */
	public Complex multi(Complex complex) {
		Complex answer = new Complex();
		answer.real = this.real*complex.real - this.image*complex.image;
		answer.image = this.real*complex.image + this.image*complex.real;

		return answer;
	}

	/**
	 * 除算.
	 * @param complex 複素数
	 * @return 除算結果
	 */
	public Complex div(Complex complex) {
		Complex answer = new Complex();
		answer.real = (this.real*complex.real + this.image*complex.image)/(complex.real*complex.real + complex.image*complex.image);
		answer.image = (this.image*complex.real- this.real*complex.image)/(complex.real*complex.real + complex.image*complex.image);

		return answer;
	}

	@Override
	public String toString() {
		var sb = new StringBuilder();
		sb.append(real);
		sb.append(image < 0 ? "-" : "+");
		sb.append(image);
		return sb.toString();
	}
}
