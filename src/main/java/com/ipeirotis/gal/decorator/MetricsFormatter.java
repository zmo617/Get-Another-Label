package com.ipeirotis.gal.decorator;

import java.util.Locale;

import com.ipeirotis.utils.Utils;

public abstract class MetricsFormatter {
	public abstract String format(Double result);

	public static final MetricsFormatter PERCENT_FORMATTER = new MetricsFormatter() {
		@Override
		public
		String format(Double result) {
			if (null == result || Double.isNaN(result))
				return "N/A";

			return String.format(Locale.ENGLISH, "%3.2f%%", Utils.round(100 * result, 2));
		}
	};
	
	public static final MetricsFormatter DECIMAL_FORMATTER = new MetricsFormatter() {
		@Override
		public
		String format(Double result) {
			if (null == result || Double.isNaN(result))
				return "N/A";
			
			return String.format(Locale.ENGLISH, "%2.4f", Utils.round(result, 4)).toString();
		}
	};
}