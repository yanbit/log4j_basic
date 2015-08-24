package com.yanbit;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * @author yanbit
 * @date Aug 21, 2015 4:05:27 PM
 *
 */
public class UseLog4j {
//  private static final Logger LOG = Logger.getLogger(UseLog4j.class);
  private static final Log LOG = LogFactory.getLog(UseLog4j.class);
  

  public static void main(String[] args) {
    LOG.info("-------------info");
    LOG.info("------------debug");
    LOG.error("------------error");
  }
}
