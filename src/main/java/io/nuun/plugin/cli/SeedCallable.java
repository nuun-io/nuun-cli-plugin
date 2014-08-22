package io.nuun.plugin.cli;

import io.nuun.plugin.cli.api.NuunCliHandler;
import io.nuun.plugin.log.NuunLog;

import java.util.concurrent.Callable;

import javax.inject.Inject;

import org.slf4j.Logger;
 
class SeedCallable implements Callable<Integer>
    {
        @NuunLog
        Logger logger;
        
        @Inject
        NuunCliHandler commandLineHandler;
        
        @Override
        public Integer call() throws Exception {
            logger.info("Starting Command Line Handler : " + commandLineHandler.name());
            try {
                return commandLineHandler.call();
            } finally {
                logger.info("Ending Command Line Handler. " + commandLineHandler.name());
            }
        }
    }