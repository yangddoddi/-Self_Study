package OOP.Basic;

class InstallException extends Exception {
    InstallException(String msg) {
        super(msg);
    }
}

class SpaceException extends Exception {
    SpaceException(String msg) {
        super(msg);
    }
}

class MemoryException extends Exception {
    MemoryException(String msg) {
        super(msg);
    }
}

public class CostumException {
    static void startInstall() throws MemoryException, SpaceException {
        if (!enoughMemory()) {
            throw new MemoryException("메모리 용량 부족");
        }
        if (!enoughSpace()) {
            throw new SpaceException("하드디스크 용량 부족");
        }
    }
    static void install() throws InstallException {
        try {
            startInstall();
            copyFiles();
        } catch (SpaceException | MemoryException e) {
            InstallException ie = new InstallException("예외 발생");
            ie.initCause(e); // StackTrace에서 보이는 원인 예외로 넣어준다.
            throw ie;
        } finally {
            deleteTempFiles(); // 임시 파일은 설치가 실패하던 성공하던 삭제한다.
        }
    }
    static boolean enoughMemory() { return true; }
    static boolean enoughSpace() { return false; }
    static void copyFiles() {};
    static void deleteTempFiles() {};

    public static void main(String[] args) throws InstallException {
        install();
    }
}
