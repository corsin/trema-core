package ch.netcetera.trema.core.exporting;

import org.apache.commons.lang.StringUtils;

import ch.netcetera.trema.core.api.IExportFilter;
import ch.netcetera.trema.core.api.IKeyValuePair;

/**
 * Filter for converting newlines (\n, \r\n and \r) into HTML
 * line breaks (<code><br/></code>).
 * Note that the newlines in the value are written out, meaning '\n' are
 * actually two characters instead of the character with ASCII code 10.
 */
public class HtmlLineBreakConverter implements IExportFilter {
  private static final String REPLACEMENT = "<br/>";


  @Override
  public void filter(IKeyValuePair keyValuePair) {
    String value = keyValuePair.getValue();
    if (value != null) {
      String newValue = StringUtils.replace(value, "\\r\\n", REPLACEMENT);
      newValue = StringUtils.replace(newValue, "\\n", REPLACEMENT);
      newValue = StringUtils.replace(newValue, "\\r", REPLACEMENT);
      keyValuePair.setValue(newValue);
    }
  }
}
