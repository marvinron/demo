package com.example.demo.params;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.concurrent.TimeoutException;

public class ProcessExecutor {
    private final String command;
    private final String arguments;
    private final Runtime runtime = Runtime.getRuntime();
    private boolean finished;

    public ProcessExecutor(String processName, String... arguments) {
        StringBuilder argumentsBuilder = new StringBuilder();
        if(argumentsBuilder != null){
            for(String argument:arguments){
                argumentsBuilder.append(" ").append(argument);
            }

        }
        this.arguments = argumentsBuilder.toString();
        this.command = processName+ this.arguments;


    }
    public void execute(OutputStream outputStream, long timeoutInMilliseconds) throws IOException, TimeoutException {
        Process process = runtime.exec(command);
        long startTime = System.currentTimeMillis();
        long endTime = -1L;
        InputStream processInputStream = process.getInputStream();
        InputStream processErrorInputStream = process.getErrorStream();
//        OutputStream processOutputStream = process.getOutputStream();
        int exitValue = -1;
        while (!finished) {
            long costTime = endTime - startTime;
            if (costTime > timeoutInMilliseconds) {
                finished = true;
                process.destroy();
                String message = String.format("Execution is timeout[%d ms]!", timeoutInMilliseconds);
                throw new TimeoutException(message);
            }
            try {
                while (processInputStream.available() > 0) {
                    outputStream.write(processInputStream.read());
                }
                while (processErrorInputStream.available() > 0) {
                    outputStream.write(processErrorInputStream.read());
                }
                exitValue = process.exitValue();
                if (exitValue != 0) {
                    throw new IOException();
                }
                finished = true;
            } catch (IllegalThreadStateException e) {
                // Process is not finished yet;
                // Sleep a little to save on CPU cycles
                endTime = System.currentTimeMillis();
        }
        }



    }

    public static void main(String[] args) {
        ProcessExecutor executor = new ProcessExecutor("java","-version");
        try {
            executor.execute(System.out,2000);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
    }


}
