package fr.ndavid.tp2;

public class LoggerBuilder {
        public String message;
        public String classe;
        public String method;
        public LogType type;

        LoggerBuilder withMessage(String message){
            this.message=message;
            return this;
        }
        LoggerBuilder withClass(String classe){
            this.classe=classe;
            return this;
        }LoggerBuilder withMethod(String method){
            this.method=method;
            return this;
        }
        LoggerBuilder withState(LogType type) {
            this.type = type;
            return this;
        }
}
