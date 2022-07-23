package com.ziojio.code;

import java.io.File;
import java.io.IOException;

public class FileUtils {

    public static boolean isExists(String filepath) {
        return isExists(getFileByPath(filepath));
    }

    public static boolean isExists(File file) {
        return file != null && file.exists();
    }

    public static boolean isDir(final String dirPath) {
        return isDir(getFileByPath(dirPath));
    }

    /**
     * Return whether it is a directory.
     */
    public static boolean isDir(final File file) {
        return file != null && file.exists() && file.isDirectory();
    }

    public static boolean isFile(final String filePath) {
        return isFile(getFileByPath(filePath));
    }

    /**
     * Return whether it is a file.
     */
    public static boolean isFile(final File file) {
        return file != null && file.exists() && file.isFile();
    }

    public static boolean createOrExistsDir(final String dirPath) {
        return createOrExistsDir(getFileByPath(dirPath));
    }

    /**
     * Create a directory if it doesn't exist, otherwise do nothing.
     */
    public static boolean createOrExistsDir(final File file) {
        return file != null && (file.exists() ? file.isDirectory() : file.mkdirs());
    }

    public static boolean createOrExistsFile(final String filePath) {
        return createOrExistsFile(getFileByPath(filePath));
    }

    /**
     * Create a file if it doesn't exist, otherwise do nothing.
     */
    public static boolean createOrExistsFile(final File file) {
        if (file == null) return false;
        if (file.exists()) return file.isFile();
        if (!createOrExistsDir(file.getParentFile())) return false;
        try {
            return file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean rename(final String filePath, final String newName) {
        return rename(getFileByPath(filePath), newName);
    }

    /**
     * 重命名文件
     *
     * @param file    文件
     * @param newName 新名称
     */
    public static boolean rename(final File file, final String newName) {
        // 文件为空返回 false
        if (file == null) {
            return false;
        }
        // 文件不存在返回 false
        if (!file.exists()) {
            return false;
        }
        // 新的文件名为空返回 false
        if (isBlank(newName)) {
            return false;
        }
        // 如果文件名没有改变返回 true
        if (newName.equals(file.getName())) {
            return true;
        }
        File newFile = new File(file.getParent() + File.separator + newName);
        // 如果重命名的文件已存在返回 false
        return !newFile.exists() && file.renameTo(newFile);
    }

    public static boolean delete(final String filePath) {
        return delete(getFileByPath(filePath));
    }

    /**
     * Delete the file.
     */
    public static boolean delete(final File file) {
        if (file == null) return false;
        if (file.isDirectory()) {
            return deleteDir(file);
        }
        return deleteFile(file);
    }

    /**
     * Delete the directory.
     */
    private static boolean deleteDir(final File dir) {
        if (dir == null) return false;
        // dir doesn't exist then return true
        if (!dir.exists()) return true;
        // dir isn't a directory then return false
        if (!dir.isDirectory()) return false;
        File[] files = dir.listFiles();
        if (files != null && files.length > 0) {
            for (File file : files) {
                if (file.isFile()) {
                    if (!file.delete()) return false;
                } else if (file.isDirectory()) {
                    if (!deleteDir(file)) return false;
                }
            }
        }
        return dir.delete();
    }

    /**
     * Delete the file.
     */
    private static boolean deleteFile(final File file) {
        return file != null && (!file.exists() || file.isFile() && file.delete());
    }

    public static String getFileName(final File file) {
        if (file == null) return "";
        return getFileName(file.getAbsolutePath());
    }

    /**
     * Return the name of file.
     */
    public static String getFileName(final String filePath) {
        if (isBlank(filePath)) return "";
        int lastSep = filePath.lastIndexOf(File.separator);
        return lastSep == -1 ? filePath : filePath.substring(lastSep + 1);
    }

    /**
     * Return the name of file without extension.
     */
    public static String getFileNameNoExtension(final File file) {
        if (file == null) return "";
        return getFileNameNoExtension(file.getPath());
    }

    public static String getFileNameNoExtension(final String filePath) {
        if (isBlank(filePath)) return "";
        int lastPoi = filePath.lastIndexOf('.');
        int lastSep = filePath.lastIndexOf(File.separator);
        if (lastSep == -1) {
            return (lastPoi == -1 ? filePath : filePath.substring(0, lastPoi));
        }
        if (lastPoi == -1 || lastSep > lastPoi) {
            return filePath.substring(lastSep + 1);
        }
        return filePath.substring(lastSep + 1, lastPoi);
    }

    /**
     * Return the extension of file.
     */
    public static String getFileExtension(final File file) {
        if (file == null) return "";
        return getFileExtension(file.getPath());
    }

    public static String getFileExtension(final String filePath) {
        if (isBlank(filePath)) return "";
        int lastPoi = filePath.lastIndexOf('.');
        int lastSep = filePath.lastIndexOf(File.separator);
        if (lastPoi == -1 || lastSep >= lastPoi) return "";
        return filePath.substring(lastPoi + 1);
    }

    public static String getParentFilePath(String filepath) {
        if (isBlank(filepath)) {
            return "";
        }
        File file = getFileByPath(filepath);
        if (file == null) {
            return "";
        }
        if (file.isDirectory()) {
            return file.getAbsolutePath();
        }
        if (file.getParentFile() == null) {
            return "";
        }
        return file.getParentFile().getAbsolutePath() + "/";
    }

    private static File getFileByPath(final String filePath) {
        return isBlank(filePath) ? null : new File(filePath);
    }

    private static boolean isBlank(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }
        for (int i = 0, len = s.length(); i < len; ++i) {
            if (!Character.isWhitespace(s.charAt(i))) {
                return false;
            }
        }
        return true;
    }

}
