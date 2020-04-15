package me.ycastor.fangurps.commands;

import java.nio.file.Path;
import java.nio.file.Paths;

import javax.inject.Inject;

import me.ycastor.fangurps.fantasygrounds.ModWriter;
import me.ycastor.fangurps.fantasygrounds.actions.ConvertLibraryAction;
import me.ycastor.fangurps.fantasygrounds.metadata.models.FGModDefinition;
import me.ycastor.fangurps.fantasygrounds.skills.FGModType;
import me.ycastor.fangurps.gcs.skills.SkillMapper;
import me.ycastor.fangurps.parsers.GCSSkillToFGSkill;
import me.ycastor.fangurps.shared.ExceptionThrower;
import me.ycastor.fangurps.shared.file.FileReader;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;

@Command(
        name = "convert-skill",
        header = {
                "@|green  ___          ___                  |@",
                "@|green | __|_ _ _ _ / __|_  _ _ _ _ __ ___|@",
                "@|green | _/ _` | ' \\ (_ | || | '_| '_ (_-<|@",
                "@|green |_|\\__,_|_||_\\___|\\_,_|_| | .__/__/|@",
                "@|green                           |_|      |@"
        },
        description = "Converts a skill between GCS and Fantasy Grounds",
        mixinStandardHelpOptions = true,
        version = "convert-skill 0.1.0"
)
public class ConvertSkillCommand implements Runnable {

    @Option(names = {"-i", "--input"}, description = "The GCS .skl file", required = true)
    private String input;
    @Option(names = {"-o", "--output"}, description = "The output directory for the FantasyGrounds .mod file", required = true)
    private String output;
    @Option(names = {"-mn", "--mod-name"}, description = "The name of the mod", required = true)
    private String modName;

    @Inject
    private FileReader fileReader;
    @Inject
    private SkillMapper skillMapper;
    @Inject
    private GCSSkillToFGSkill gcsSkillToFGSkill;
    @Inject
    private ModWriter modWriter;

    public ConvertSkillCommand() {
    }

    public ConvertSkillCommand(
            FileReader fileReader,
            SkillMapper skillMapper,
            GCSSkillToFGSkill gcsSkillToFGSkill,
            ModWriter modWriter
    ) {
        this.fileReader = fileReader;
        this.skillMapper = skillMapper;
        this.gcsSkillToFGSkill = gcsSkillToFGSkill;
        this.modWriter = modWriter;
    }

    @Override
    public void run() {
        var gcsSkillXml = fileReader.loadFile(Path.of(input)).fold(ExceptionThrower.rethrow(), file -> file);
        var gcsSkill = skillMapper.xmlToDomain(gcsSkillXml).fold(ExceptionThrower.rethrow(), skillList -> skillList);
        var fgSkill = gcsSkillToFGSkill.parse(gcsSkill).fold(ExceptionThrower.rethrow(), fgAbility -> fgAbility);
        var modDefinition = FGModDefinition.builder().name(modName).build();
        var action = ConvertLibraryAction.builder()
                                         .libraryName(modName)
                                         .mod(fgSkill)
                                         .modType(FGModType.ABILITY)
                                         .output(Paths.get(output))
                                         .build();

        modWriter.write(modDefinition, action);
    }
}
