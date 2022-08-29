package adapter;

public interface ICacheArchive {

	public byte[] takeFile(int i, int j);

	public boolean tryLoadFile(int var1, int var2);

	public int getGroupFileCount(int var1);

	public int getGroupCount();

	public byte[] takeFileFlat(int var8);

	public int getGroupId(String string);

	public int getFileId(int var3, String string);

}
