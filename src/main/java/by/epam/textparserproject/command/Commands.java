package by.epam.textparserproject.command;

import by.epam.textparserproject.command.impl.*;

/**
 * ENUM provides a constant of the HTTP command. Provides the definition of the command based on Factory command pattern.
 * @author Igor Taren
 */
public enum Commands {
    DOWNLOAD {
        {
            this.command = new FileDownload();
        }
    },
    PARSE {
        {
            this.command = new FileParse();
        }
    },
    SHOW_CONTENT_OF_DOWNLOADED_FILE {
        {
            this.command = new ShowContentOfDownloadedFile();
        }
    },
    SHOW_ELEMENTS_DETECTED_WHILE_PARSING {
        {
            this.command = new ShowElementsDetectedWhileParsing();
        }
    },
    SHOW_PARSED_TEXT {
        {
            this.command = new ShowParsedText();
        }
    },
    SWAP_WORDS {
        {
            this.command = new SwapWords();
        }
    };

    Command command;

    public Command getCommand() {
        return command;
    }
}
