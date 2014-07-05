package com.marzeta.utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class FileCopier {
	private static final String TEST_DIR_1 = "d:/MP3";
	private static final String TEST_DIR_2 = "o:/MP3";
	private final File source;
	private final File destination;
	private long skippedFileCount;
	private long copiedFileCount;
	private long createdFolderCount;
	private long skippedFolderCount;
	private final boolean commit = false;

	public FileCopier(String source, String destination) {
		checkPath(source);
		this.source = new File(source);
		this.destination = new File(destination);
	}

	private void checkPath(String source) {
		if (!existingResource(source)) {
			throw new IllegalArgumentException("Invalid path: " + source);
		}
	}

	public void syncFolder(final File folder) throws IOException {
		for (final File resource : folder.listFiles()) {
			String sourcePath = folder + "\\" + resource.getName();
			File destPath = new File(sourcePath.replace(source + "", destination + ""));
			if (resource.isDirectory()) {
				createDir(sourcePath, destPath);
				syncFolder(resource);
			} else {
				copyFile(resource, sourcePath, destPath);
			}
		}
	}

	private void createDir(String path, File destFile) throws IOException {
		if (!destFile.exists()) {
			if (commit) {
				if (!destFile.mkdir()) {
					throw new IOException("Cannot create dir: " + destFile);
				}
			} else {
				out("Creating '" + path + "' in " + destFile);
			}
			createdFolderCount++;
		} else {
			skippedFolderCount++;
		}
	}

	private void copyFile(final File file, String path, File destFile) throws IOException {
		if (!destFile.exists()) {
			if (commit) {
				copyFile(file, destFile);
			} else {
				out("Copying '" + path + "' to " + destFile);
			}
			copiedFileCount++;
		} else {
			if (file.length() != destFile.length()) {
				out("Size mismatch: " + file);
			}
			skippedFileCount++;
			if (skippedFileCount % 10000 == 0) {
				out("Processed " + skippedFileCount + " (of 168901)...");
			}
		}
	}

	public void copyFile(File from, File to) throws IOException {
		Files.copy(from.toPath(), to.toPath());
	}

	private boolean existingResource(String destPath) {
		return new File(destPath).exists();
	}

	private void sync() throws IOException {
		long start = System.currentTimeMillis();
		out("Working...");
		if (source.isDirectory()) {
			createDir(source + "", destination);
		}
		syncFolder(source);
		long stop = System.currentTimeMillis();
		out("It took " + (stop - start) / 60000 + " minutes");
		out("Files existed: " + skippedFileCount);
		out("Files copied: " + copiedFileCount);
		out("Folders existed: " + skippedFolderCount);
		out("Folders created: " + createdFolderCount);
	}

	private void out(String text) {
		System.out.println(text);
	}

	public static void main(String[] args) throws IOException {
		if (args.length > 2) {
			new FileCopier(args[1], args[2]).sync();
		} else {
			new FileCopier(TEST_DIR_1, TEST_DIR_2).sync();
		}
	}
}
