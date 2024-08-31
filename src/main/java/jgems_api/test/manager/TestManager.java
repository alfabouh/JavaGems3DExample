/*
 * *
 *  * @author alfabouh
 *  * @since 2024
 *  * @link https://github.com/alfabouh/JavaGems3D
 *  *
 *  * This software is provided 'as-is', without any express or implied warranty.
 *  * In no event will the authors be held liable for any damages arising from the use of this software.
 *
 */

/*
 * *
 *  * @author alfabouh
 *  * @since 2024
 *  * @link https://github.com/alfabouh/JavaGems3D
 *  *
 *  * This software is provided 'as-is', without any express or implied warranty.
 *  * In no event will the authors be held liable for any damages arising from the use of this software.
 *
 */

package jgems_api.test.manager;

import jgems_api.test.entities.TestPlayer;
import jgems_api.test.gui.TestMainMenuPanel;
import jgems_api.test.manager.bindings.TestBindings;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.joml.Vector3f;
import javagems3d.engine.graphics.opengl.rendering.imgui.panels.base.PanelUI;
import javagems3d.engine.graphics.opengl.world.SceneWorld;
import javagems3d.engine.physics.world.PhysicsWorld;
import javagems3d.engine.system.controller.binding.BindingManager;
import javagems3d.engine.system.core.player.IPlayerConstructor;
import javagems3d.engine.system.map.loaders.IMapLoader;
import javagems3d.engine.system.map.loaders.tbox.placers.TBoxMapDefaultObjectsPlacer;
import javagems3d.engine.system.resources.manager.GameResources;
import javagems3d.engine.system.resources.manager.JGemsResourceManager;
import javagems3d.engine.system.service.collections.Pair;
import javagems3d.engine_api.app.tbox.containers.TUserData;
import javagems3d.engine_api.configuration.AppConfiguration;
import javagems3d.engine_api.manager.AppManager;
import javagems3d.toolbox.map_sys.save.objects.object_attributes.AttributesContainer;

public class TestManager extends AppManager {
    public TestManager(@Nullable AppConfiguration appConfiguration) {
        super(appConfiguration);
    }

    @Override
    public @NotNull BindingManager createBindingManager() {
        return new TestBindings();
    }

    @Override
    public @NotNull IPlayerConstructor createPlayer(IMapLoader mapLoader) {
        return (w, p, r) -> new Pair<>(new TestPlayer(w, p, r), JGemsResourceManager.globalRenderDataAssets.player);
    }

    public @NotNull PanelUI gameMainMenuPanel() {
        return new TestMainMenuPanel(null);
    }
}
